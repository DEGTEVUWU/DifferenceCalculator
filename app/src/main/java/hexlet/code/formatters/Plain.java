package hexlet.code.formatters;

import hexlet.code.Status;
import org.apache.commons.lang3.StringUtils;

import java.util.TreeMap;

public class Plain {
    public static String plain(TreeMap<String, Status> mapWithKeysStatus) {
        String resultString = "";

        for (var keyWithStatus : mapWithKeysStatus.entrySet()) {
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
    }
}
