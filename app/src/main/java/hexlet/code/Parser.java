package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.IOException;
import java.util.TreeMap;

public class Parser {
    private static TreeMap parseYaml(String content) throws IOException {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(content, TreeMap.class);
    }

    private static TreeMap parseJson(String content) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, TreeMap.class);
    }

    public static TreeMap<String, Object> parse(String fileData, String fileFormat) throws IOException {
        switch (fileFormat) {
            case "yml":
                return parseYaml(fileData);
            case "json":
                return parseJson(fileData);
            default:
                throw new IOException("Unknown format: '" + fileFormat + "'");
        }
    }
}
