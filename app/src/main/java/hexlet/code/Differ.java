package hexlet.code;

//import com.fasterxml.jackson.databind.JavaType;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
//import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
//import java.util.stream.Collectors;

public class Differ {

    public static ArrayList getListFiles(String str) {
        ArrayList<File> listWithFileNames = new ArrayList<>();

        File f = new File(str);
        for (File s : f.listFiles()) {
            if (s.isFile()) {
                listWithFileNames.add(s);
            } else if (s.isDirectory()) {
                getListFiles(s.getAbsolutePath());
            }
        }
        return listWithFileNames;
    }

    public static String generate(String path1, String path2) throws IOException {
        String resultString = "{ \n";

        TreeMap<String, Object> map1 = Parser.parser(path1);
        TreeMap<String, Object> map2 = Parser.parser(path2);

        for (Map.Entry<String, Object> item : map1.entrySet()) {
            if (map1.get(item.getKey()).equals(map2.get(item.getKey()))) {
                resultString = resultString + "    " + item + "\n";
            } else {
                resultString = resultString + "  " + "- " + item + "\n";
            }
        }

        for (Map.Entry<String, Object> item : map2.entrySet()) {
            if (!(map2.get(item.getKey()).equals(map1.get(item.getKey())))) {
                resultString = resultString + "  " + "+ " + item + "\n";
            }
        }

        resultString = resultString + "}";

        return resultString;
    }
}

