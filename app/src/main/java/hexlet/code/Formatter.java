package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.io.IOException;
import java.util.TreeMap;

public class Formatter {
    public static String formatter(TreeMap<String, Status> mapWithStatusKeys, String format)
            throws IOException {
        String resultString = "";
        return switch (format) {
            case "stylish" -> resultString = Stylish.render(mapWithStatusKeys);
            case "plain" -> resultString = Plain.render(mapWithStatusKeys);
            case "json" -> resultString = Json.render(mapWithStatusKeys);
            default -> throw new IOException("Unknown format: '" + format + "'");
        };

    }
}
