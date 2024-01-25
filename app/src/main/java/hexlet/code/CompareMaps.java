package hexlet.code;

import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CompareMaps {
    public static TreeMap<String, Status> compareMaps(TreeMap<String, Object> map1, TreeMap<String, Object> map2) {
        TreeMap<String, Status> resultMap = new TreeMap<>();

        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        for (var key : keys) {
            Object oldValue = map1.get(key);
            Object newValue = map2.get(key);

            if (!map1.containsKey(key)) {
                resultMap.put(key, new Status(oldValue, newValue, "added"));
            } else if (!map2.containsKey(key)) {
                resultMap.put(key, new Status(oldValue, newValue, "deleted"));
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                resultMap.put(key, new Status(oldValue, newValue, "unchanged"));
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                resultMap.put(key, new Status(oldValue, newValue, "changed"));
            }
        }

        return resultMap;

    }
}
