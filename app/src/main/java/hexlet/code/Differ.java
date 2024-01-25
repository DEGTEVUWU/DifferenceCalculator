package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Differ {
    public static String generate(String path1, String path2, String format) throws Exception {
        TreeMap<String, Object> map1 = getData(path1);
        TreeMap<String, Object> map2 = getData(path2);

        TreeMap<String, Status> mapWithStatusKeys = CompareMaps.compareMaps(map1, map2);

        return Formatter.formatter(mapWithStatusKeys, format);

    }

    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }

    public static TreeMap<String, Object> getData(String filePath) throws Exception {

        Path fullPath = getFullPath(filePath);

        if (!Files.exists(fullPath)) {
            throw new Exception("File '" + fullPath + "' does not exist");
        }

        String content = Files.readString(fullPath);
        String dataFormat = getDataFormat(filePath);

        return Parser.parse(content, dataFormat);

    }
    public static Path getFullPath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();

    }
    public static String getDataFormat(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index > 0
                ? filePath.substring(index + 1)
                : "";
    }
}


