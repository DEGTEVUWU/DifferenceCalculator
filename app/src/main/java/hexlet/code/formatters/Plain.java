package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Plain {
    public static String plain(TreeMap<String, Object> map1, TreeMap<String, Object> map2,
                               TreeMap<String, Status> mapWithStatusKeys) {
        String resultString = "";
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();

        Set<String> set = new TreeSet<>(map1.keySet());
        Set<String> set2 = new TreeSet<>(map2.keySet());
        set.addAll(set2);

        for (var key : set) {

            if (mapWithStatusKeys.get(key).isStatus().equals("changed")) {
                Object value1;
                Object value2;
                if (propertyValue(map1.get(key)).equals("Simple type")) {
                    value1 = map1.get(key);
                } else if (propertyValue(map1.get(key)).equals("String type")) {
                    value1 = "'" + map1.get(key) + "'";
                } else {
                    value1 = "[complex value]";
                }

                if (propertyValue(map2.get(key)).equals("Simple type")) {
                    value2 = map2.get(key);
                } else if (propertyValue(map2.get(key)).equals("String type")) {
                    value2 = "'" + map2.get(key) + "'";
                } else {
                    value2 = "[complex value]";
                }
                resultString += "\nProperty '" + key + "' was updated. From " + value1 + " to " + value2;
            } else if (mapWithStatusKeys.get(key).isStatus().equals("deleted")) {

                resultString += "\nProperty '" + key + "' was removed";
            } else if (mapWithStatusKeys.get(key).isStatus().equals("added")) {
                Object value;
                if (propertyValue(map2.get(key)).equals("Simple type")  ) {
                    value = map2.get(key);
                } else if (propertyValue(map2.get(key)).equals("String type")){
                    value = "'" + map2.get(key) + "'";
                } else {
                    value = "[complex value]";
                }
                resultString += "\nProperty '" + key + "' was added with value: " + value;
            }
        }

        return resultString;
    }

    public static String propertyValue (Object value1) {
        if (value1 instanceof Integer || value1 instanceof Character ||
            value1 instanceof Boolean || value1 instanceof Double || value1 instanceof Float || value1 instanceof Long ||
        value1 == null) {
            return "Simple type";
        } else if(value1 instanceof String) {
            return  "String type";
        } else if (value1.getClass().isArray()) {
            return "Composite type";
        }
        return "Composite type";
    }
}
