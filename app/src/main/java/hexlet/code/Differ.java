package hexlet.code;

//import com.fasterxml.jackson.databind.JavaType;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import com.sun.source.tree.Tree;

import java.io.File;
import java.io.IOException;
//import java.nio.file.Paths;
import java.io.ObjectInputFilter;
import java.util.*;
//import java.util.stream.Collectors;

public class Differ {
    public static String generate(String path1, String path2) throws IOException {
        TreeMap<String, Object> map1 = Parser.parser(path1);
        TreeMap<String, Object> map2 = Parser.parser(path2);

        TreeMap<String, Status> mapWithStatusKeys = CompareMaps.compareMaps(map1, map2);
        String resultString = stylish(map1, map2, mapWithStatusKeys);

        /*
        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

         */
        return resultString;
    }

    public static String stylish(TreeMap<String, Object> map1, TreeMap<String, Object> map2, TreeMap<String, Status> mapWithStatusKeys) {
        String resultString = "{ \n";
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();

        Set<String> set = new TreeSet<>(map1.keySet());
        Set<String> set2 = new TreeSet<>(map2.keySet());
        set.addAll(set2);

        for (var key : set) {
            if (mapWithStatusKeys.get(key).isStatus().equals("unchanged")) {
                resultMap.put(key, map1.get(key));
                resultString += " ".repeat(4) + key + ": " + String.valueOf(map1.get(key)) + "\n";
            } else if (mapWithStatusKeys.get(key).isStatus().equals("changed")) {
                resultMap.put("-" + key, map1.get(key));
                resultMap.put("+" + key, map2.get(key));
                resultString += " ".repeat(2) + "- " + key + ": " + String.valueOf(map1.get(key)) + "\n";
                resultString += " ".repeat(2) + "+ " + key + ": " + String.valueOf(map2.get(key)) + "\n";
            } else if (mapWithStatusKeys.get(key).isStatus().equals("deleted")) {
                resultMap.put("-" + key, map1.get(key));
                resultString += " ".repeat(2) + "- " + key + ": " + String.valueOf(map1.get(key)) + "\n";
            } else if (mapWithStatusKeys.get(key).isStatus().equals("added")) {
                resultMap.put("+" + key, map2.get(key));
                resultString += " ".repeat(2) + "+ " + key + ": " + String.valueOf(map2.get(key)) + "\n";
            }
        }
        resultString += "}";
        return resultString;
    }
}

