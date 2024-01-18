package hexlet.code.formatters;

import hexlet.code.Status;
import org.apache.commons.lang3.StringUtils;
import java.util.TreeMap;

public class Json {
    public static String json(TreeMap<String, Status> mapWithKeysStatus) {
        String resultString = "{";

        for (var keyWithStatus : mapWithKeysStatus.entrySet()) {
            var key = keyWithStatus.getKey();
            var data = keyWithStatus.getValue();

            if (data.isStatus().equals("unchanged")) {
                Object value;

                if (PropertyValue.propertyValue(data.getOldValue()).equals("String type")) {
                    value = "\"" + data.getOldValue() + "\"";
                } else {
                    value = data.getOldValue();
                }

                resultString += "\"" + key + "\"" + ":" + value + ",";

            } else if (data.isStatus().equals("changed")) {
                Object value1;
                Object value2;

                if (PropertyValue.propertyValue(data.getOldValue()).equals("String type")) {
                    value1 = "\"" + data.getOldValue() + "\"";
                } else {
                    value1 = data.getOldValue();
                }
                if (PropertyValue.propertyValue(data.getNewValue()).equals("String type")) {
                    value2 = "\"" + data.getNewValue() + "\"";
                } else {
                    value2 = data.getNewValue();
                }

                resultString += "\"" + "-" + key + "\"" + ":" + value1 + ",";
                resultString += "\"" + "+" + key + "\"" + ":" + value2 + ",";

            } else if (data.isStatus().equals("deleted")) {
                Object value;

                if (PropertyValue.propertyValue(data.getOldValue()).equals("String type")) {
                    value = "\"" + data.getOldValue() + "\"";
                } else {
                    value = data.getOldValue();
                }

                resultString += "\"" + "-" + key + "\"" + ":" + value + ",";

            } else if (data.isStatus().equals("added")) {
                Object value;

                if (PropertyValue.propertyValue(data.getNewValue()).equals("String type")) {
                    value = "\"" + data.getNewValue() + "\"";
                } else {
                    value = data.getNewValue();
                }

                resultString += "\"" + "+" + key + "\"" + ":" + value + ",";
            }
        }

        resultString = StringUtils.chop(resultString);
        resultString += "}";
        return resultString;
    }
}
