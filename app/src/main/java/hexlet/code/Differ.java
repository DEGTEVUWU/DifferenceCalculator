package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Differ {
    public static String generate(String path1, String path2, String format) throws Exception {
        String firstFileData = readFile(path1);
        String secondFileData = readFile(path2);
        String firstFileFormat = getDataFormat(path1);
        String secondFileFormat = getDataFormat(path1);

        TreeMap<String, Object> map1 =  Parser.parse(firstFileData, firstFileFormat);
        TreeMap<String, Object> map2 =  Parser.parse(secondFileData, secondFileFormat);

        TreeMap<String, Status> mapWithStatusKeys = CompareMaps.compareMaps(map1, map2);

        return Formatter.formatter(mapWithStatusKeys, format);

    }

    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }

    public static String readFile(String filePath) throws Exception {
        Path fullPath;
        if (Files.exists(Paths.get(filePath))) {
            fullPath = Paths.get(filePath);
        } else {
            fullPath = Paths.get("./src/main/resources/fixtures", filePath);
        }

        if (!Files.exists(fullPath)) {
            throw new IOException("File '" + fullPath + "' does not exist");
        }

        return Files.readString(fullPath);

    }

    public static String getDataFormat(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index > 0
                ? filePath.substring(index + 1)
                : "";
    }
}


