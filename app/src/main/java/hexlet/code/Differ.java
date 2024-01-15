package hexlet.code;

//import com.fasterxml.jackson.databind.JavaType;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

//import com.sun.source.tree.Tree;

//import java.io.File;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
//import java.nio.file.Paths;
//import java.io.ObjectInputFilter;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
//import java.util.stream.Collectors;

public class Differ {
    public static String generate(String path1, String path2, String format) throws IOException {
        TreeMap<String, Object> map1 = Parser.parser(path1);
        TreeMap<String, Object> map2 = Parser.parser(path2);

        TreeMap<String, Status> mapWithStatusKeys = CompareMaps.compareMaps(map1, map2);

        String resultString = Formatter.formater(map1, map2, mapWithStatusKeys, format);

        return resultString;
    }

    public static String generate(String path1, String path2) throws IOException {
        return generate(path1, path2, "stylish");
    }
}


