package hexlet.code.formatters;

import hexlet.code.Status;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Json {
    public static String json(TreeMap<String, Object> map1, TreeMap<String, Object> map2,
                                 TreeMap<String, Status> mapWithStatusKeys) {
        String resultString = "{";

        Set<String> set = new TreeSet<>(map1.keySet());
        Set<String> set2 = new TreeSet<>(map2.keySet());
        set.addAll(set2);

        for (var key : set) {
            if (mapWithStatusKeys.get(key).isStatus().equals("unchanged")) {
                Object value;
                if (PropertyValue.propertyValue(map1.get(key)).equals("String type")) {
                    value = "\"" + map1.get(key) + "\"";
                } else {
                    value = map1.get(key);
                }

                resultString += "\"" + key + "\"" + ":" + value + ",";

            } else if (mapWithStatusKeys.get(key).isStatus().equals("changed")) {
                Object value1;
                Object value2;

                if (PropertyValue.propertyValue(map1.get(key)).equals("String type")) {
                    value1 = "\"" + map1.get(key) + "\"";
                } else {
                    value1 = map1.get(key);
                }
                if (PropertyValue.propertyValue(map2.get(key)).equals("String type")) {
                    value2 = "\"" + map2.get(key) + "\"";
                } else {
                    value2 = map2.get(key);
                }

                resultString += "\"" + "-" + key + "\"" + ":" + value1 + ",";
                resultString += "\"" + "+" + key + "\"" + ":" + value2 + ",";

            } else if (mapWithStatusKeys.get(key).isStatus().equals("deleted")) {
                Object value;

                if (PropertyValue.propertyValue(map1.get(key)).equals("String type")) {
                    value = "\"" + map1.get(key) + "\"";
                } else {
                    value = map1.get(key);
                }

                resultString += "\"" + "-" + key + "\"" + ":" + value + ",";

            } else if (mapWithStatusKeys.get(key).isStatus().equals("added")) {
                Object value;

                if (PropertyValue.propertyValue(map1.get(key)).equals("String type")) {
                    value = "\"" + map1.get(key) + "\"";
                } else {
                    value = map1.get(key);
                }

                resultString += "\"" + "+" + key + "\"" + ":" + value + ",";
            }
        }
        resultString = StringUtils.chop(resultString);
        resultString += "}";
        return resultString;
    }
}
