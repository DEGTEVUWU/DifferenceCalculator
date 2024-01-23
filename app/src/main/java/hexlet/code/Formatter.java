package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.TreeMap;

public class Formatter {
    public static String formatter(TreeMap<String, Status> mapWithStatusKeys, String format)
            throws IOException {
        return switch (format) {
            case "stylish" -> Stylish.render(mapWithStatusKeys);
            case "plain" -> Plain.render(mapWithStatusKeys);
            case "json" -> Json.render(mapWithStatusKeys);
            default -> throw new IOException("Unknown format: '" + format + "'");
        };

        /*
        if (format.equals("stylish")) {
            resultString = Stylish.render(mapWithStatusKeys);
        } else if (format.equals("plain")) {
            resultString = Plain.render(mapWithStatusKeys);
        } else if (format.equals("json")) {
            resultString = Json.render(mapWithStatusKeys);
        }

         */

    }
}
