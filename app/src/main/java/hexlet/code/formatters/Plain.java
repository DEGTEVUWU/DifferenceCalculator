package hexlet.code.formatters;

import hexlet.code.Status;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Plain {
    public static String propertyValue(Object value1) {
        if (value1 == null) {
            return "null";
        } else if (value1 instanceof String) {
            return "'" + value1 + "'";
        } else if (value1 instanceof Map || value1 instanceof List) {
            return "[complex value]";
        }
        return value1.toString();
    }

    public static String render(TreeMap<String, Status> mapWithKeysStatus) throws IOException {
        String resultString = "";

        for (var keyWithStatus : mapWithKeysStatus.entrySet()) {
            var type = keyWithStatus.getValue().isStatus();
            var key = keyWithStatus.getKey();
            var formattedOldValue = propertyValue(keyWithStatus.getValue().getOldValue());
            var formattedNewValue = propertyValue(keyWithStatus.getValue().getNewValue());

            switch (type) {
                case "added":
                    resultString += "Property '" + key + "' was added"
                            + " with value: " + formattedNewValue + "\n";
                    break;
                case "deleted":
                    resultString += "Property '" + key + "' was removed" + "\n";
                    break;
                case "changed":
                    resultString += "Property '" + key + "' was updated."
                            + " From " + formattedOldValue
                            + " to " + formattedNewValue + "\n";
                    break;
                case "unchanged":
                    resultString += "";
                    break;
                default:
                    throw new IOException("Unknown node type: '" + type + "'");
            }
        }
        resultString = StringUtils.chop(resultString);
        return resultString;

    }
}
