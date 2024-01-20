package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Parser {
    public static TreeMap<String, Object> parser(String filePath) {
        TreeMap<String, Object> resultMap = new TreeMap<>();
        ObjectMapper objectMapperJson = new ObjectMapper();
        ObjectMapper objectMapperYml = new YAMLMapper();

            try {
                String fileContent = readFile(filePath);
                if (Differ.getDataFormat(filePath).equals("json")) {
                    resultMap = objectMapperJson.readValue(fileContent, TreeMap.class);
                }
                if (Differ.getDataFormat(filePath).equals("yml")) {
                    resultMap = objectMapperYml.readValue(fileContent, TreeMap.class);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return resultMap;
        }

        private static String readFile(String filePath) throws IOException {
            Path path;
            if (Files.exists(Paths.get(filePath))) {
                path = Paths.get(filePath);
            } else {
                path = Paths.get("./src/main/resources", filePath);
            }

            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            }

            return content.toString();
        }
    }
