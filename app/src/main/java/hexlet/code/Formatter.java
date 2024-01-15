package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.TreeMap;

public class Formatter {
    public static String formater(TreeMap<String, Object> map1, TreeMap<String, Object> map2,
                                  TreeMap<String, Status> mapWithStatusKeys, String format) {
        String resultString = "";
        if (format.equals("stylish")) {
            resultString = Stylish.stylish(map1, map2, mapWithStatusKeys);
        } else if (format.equals("plain")) {
            resultString = Plain.plain(map1, map2, mapWithStatusKeys);
        } else if (format.equals("json")) {
            resultString = Json.json(map1, map2, mapWithStatusKeys);
        }
        return resultString;
    }
}
