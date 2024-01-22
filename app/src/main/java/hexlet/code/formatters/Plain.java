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

/*
            var key = keyWithStatus.getKey();
            var data = keyWithStatus.getValue();

            if (data.isStatus().equals("changed")) {
                Object value1;
                Object value2;
                if (PropertyValue.propertyValue(data.getOldValue()).equals("Simple type")) {
                    value1 = data.getOldValue();
                } else if (PropertyValue.propertyValue(data.getOldValue()).equals("String type")) {
                    value1 = "'" + data.getOldValue() + "'";
                } else {
                    value1 = "[complex value]";
                }

                if (PropertyValue.propertyValue(data.getNewValue()).equals("Simple type")) {
                    value2 = data.getNewValue();
                } else if (PropertyValue.propertyValue(data.getNewValue()).equals("String type")) {
                    value2 = "'" + data.getNewValue() + "'";
                } else {
                    value2 = "[complex value]";
                }
                resultString += "Property '" + key + "' was updated. From " + value1 + " to " + value2 + "\n";
            } else if (data.isStatus().equals("deleted")) {
                resultString += "Property '" + key + "' was removed" + "\n";
            } else if (data.isStatus().equals("added")) {
                Object value;
                if (PropertyValue.propertyValue(data.getNewValue()).equals("Simple type")) {
                    value = data.getNewValue();
                } else if (PropertyValue.propertyValue(data.getNewValue()).equals("String type")) {
                    value = "'" + data.getNewValue() + "'";
                } else {
                    value = "[complex value]";
                }
                resultString += "Property '" + key + "' was added with value: " + value + "\n";
            }
        }

        resultString = StringUtils.chop(resultString);
        return resultString;

 */
    }
}
