package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.TreeMap;

public class Formatter {
    public static String formatter(TreeMap<String, Status> mapWithStatusKeys, String format)
            throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.render(mapWithStatusKeys);
            case "plain" -> Plain.render(mapWithStatusKeys);
            case "json" -> Json.render(mapWithStatusKeys);
            default -> throw new Exception("Unknown format: '" + format + "'");
        };
    }
}
