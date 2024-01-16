package hexlet.code;

import java.io.IOException;
import java.util.TreeMap;

public class Differ {
    public static String generate(String path1, String path2, String format) throws IOException {
        TreeMap<String, Object> map1 = Parser.parser(path1);
        TreeMap<String, Object> map2 = Parser.parser(path2);

        TreeMap<String, Status> mapWithStatusKeys = CompareMaps.compareMaps(map1, map2);

        String resultString = Formatter.formatter(map1, map2, mapWithStatusKeys, format);

        return resultString;
    }

    public static String generate(String path1, String path2) throws IOException {
        return generate(path1, path2, "stylish");
    }
}


