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

    public static TreeMap<String, Object> parse(String data, String format) throws Exception {
        return switch (format) {
            case "yml" ->  parseYaml(data);
            case "json" ->  parseJson(data);
            default -> throw new Exception("Unknown format: '" + format + "'");
        };
    }
}
