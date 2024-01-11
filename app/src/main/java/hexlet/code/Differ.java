package hexlet.code;

//import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
//import java.util.stream.Collectors;

public class Differ {
    public static String generate(File file1, File file2) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String resultString = "{ \n";
        TreeMap<String, Object> map1 = new TreeMap<>();
        TreeMap<String, Object> map2 = new TreeMap<>();

        map1 = objectMapper.readValue(file1, TreeMap.class);
        map2 = objectMapper.readValue(file2, TreeMap.class);

        //map1 = objectMapper.readValue(new File("file1.json"), TreeMap.class);
        //map2 = objectMapper.readValue(new File("file2.json"), TreeMap.class);

        for (Map.Entry<String, Object> item : map1.entrySet()) {
            if (map1.get(item.getKey()).equals(map2.get(item.getKey()))) {
                resultString = resultString + "    " + item + "\n";
            } else {
                resultString = resultString + "  " + "- " + item + "\n";
            }
        }
        for (Map.Entry<String, Object> item : map2.entrySet()) {
            if (!(map2.get(item.getKey()).equals(map1.get(item.getKey())))) {
                resultString = resultString + "  " + "+ " + item + "\n";
            }
        }
        resultString = resultString + "}";
        return resultString;
    }
}

