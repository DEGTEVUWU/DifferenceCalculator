package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Stylish {
    public static String stylish(TreeMap<String, Object> map1, TreeMap<String, Object> map2,
                                 TreeMap<String, Status> mapWithStatusKeys) {
        String resultString = "{ \n";
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();

        Set<String> set = new TreeSet<>(map1.keySet());
        Set<String> set2 = new TreeSet<>(map2.keySet());
        set.addAll(set2);

        for (var key : set) {
            if (mapWithStatusKeys.get(key).isStatus().equals("unchanged")) {
                resultMap.put(key, map1.get(key));
                resultString += " ".repeat(4) + key + ": " + map1.get(key) + "\n";
            } else if (mapWithStatusKeys.get(key).isStatus().equals("changed")) {
                resultMap.put("-" + key, map1.get(key));
                resultMap.put("+" + key, map2.get(key));
                resultString += " ".repeat(2) + "- " + key + ": " + map1.get(key) + "\n";
                resultString += " ".repeat(2) + "+ " + key + ": " + map2.get(key) + "\n";
            } else if (mapWithStatusKeys.get(key).isStatus().equals("deleted")) {
                resultMap.put("-" + key, map1.get(key));
                resultString += " ".repeat(2) + "- " + key + ": " + map1.get(key) + "\n";
            } else if (mapWithStatusKeys.get(key).isStatus().equals("added")) {
                resultMap.put("+" + key, map2.get(key));
                resultString += " ".repeat(2) + "+ " + key + ": " + map2.get(key) + "\n";
            }
        }
        resultString += "}";
        return resultString;
    }
}
