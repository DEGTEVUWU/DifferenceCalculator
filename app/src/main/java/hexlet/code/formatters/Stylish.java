package hexlet.code.formatters;

import hexlet.code.Status;
import java.util.TreeMap;

public class Stylish {
    public static String stylish(TreeMap<String, Status> mapWithKeysStatus) {
        String resultString = "{\n";

        for (var keyWithStatus : mapWithKeysStatus.entrySet()) {
            var key = keyWithStatus.getKey();
            var data = keyWithStatus.getValue();

            if (data.isStatus().equals("unchanged")) {
                resultString += " ".repeat(4) + key + ": " + data.getOldValue() + "\n";
            } else if (data.isStatus().equals("changed")) {
                resultString += " ".repeat(2) + "- " + key + ": " + data.getOldValue() + "\n";
                resultString += " ".repeat(2) + "+ " + key + ": " + data.getNewValue() + "\n";
            } else if (data.isStatus().equals("deleted")) {
                resultString += " ".repeat(2) + "- " + key + ": " + data.getOldValue() + "\n";
            } else if (data.isStatus().equals("added")) {
                resultString += " ".repeat(2) + "+ " + key + ": " + data.getNewValue() + "\n";
            }
        }

        resultString += "}";
        return resultString;
    }
}
