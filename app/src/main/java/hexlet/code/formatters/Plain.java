package hexlet.code.formatters;

import hexlet.code.Status;
import org.apache.commons.lang3.StringUtils;

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
                if (PropertyValue.propertyValue(map1.get(key)).equals("Simple type")) {
                    value1 = map1.get(key);
                } else if (PropertyValue.propertyValue(map1.get(key)).equals("String type")) {
                    value1 = "'" + map1.get(key) + "'";
                } else {
                    value1 = "[complex value]";
                }

                if (PropertyValue.propertyValue(map2.get(key)).equals("Simple type")) {
                    value2 = map2.get(key);
                } else if (PropertyValue.propertyValue(map2.get(key)).equals("String type")) {
                    value2 = "'" + map2.get(key) + "'";
                } else {
                    value2 = "[complex value]";
                }
                resultString += "Property '" + key + "' was updated. From " + value1 + " to " + value2 + "\n";
            } else if (mapWithStatusKeys.get(key).isStatus().equals("deleted")) {

                resultString += "Property '" + key + "' was removed" + "\n";
            } else if (mapWithStatusKeys.get(key).isStatus().equals("added")) {
                Object value;
                if (PropertyValue.propertyValue(map2.get(key)).equals("Simple type")  ) {
                    value = map2.get(key);
                } else if (PropertyValue.propertyValue(map2.get(key)).equals("String type")){
                    value = "'" + map2.get(key) + "'";
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
