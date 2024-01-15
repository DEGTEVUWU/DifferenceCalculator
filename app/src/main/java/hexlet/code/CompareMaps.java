package hexlet.code;

import java.util.TreeMap;

public class CompareMaps {
    public static TreeMap<String, Status> compareMaps(TreeMap<String, Object> map1, TreeMap<String, Object> map2) {
        TreeMap<String, Status> resultMap = new TreeMap<>();

        for (String everyKey : map1.keySet()) {
            String key = everyKey;
            Object value1 = map1.get(everyKey);

            if (map2.containsKey(everyKey)) {
                Object value2 = map2.get(everyKey);
                if (compareValues(value1, value2)) {
                    resultMap.put(key, new Status(key, "unchanged"));
                } else {
                    resultMap.put(key, new Status(key, "changed"));
                }
            } else {
                resultMap.put(key, new Status(key, "deleted"));
            }
        }

        for (String everyKey : map2.keySet()) {
            String key = everyKey;
            Object value2 = map2.get(everyKey);

            if (!map1.containsKey(everyKey)) {
                resultMap.put(key, new Status(key, "added"));
            }
        }

        return resultMap;

    }

    public static boolean compareValues(Object value1, Object value2) {
        if (value1 == null && value2 == null) {
            return true;
        }
        if (value1 == null || value2 == null) {
            return false;
        }
        return value1.toString().equals(value2.toString());
    }
}
