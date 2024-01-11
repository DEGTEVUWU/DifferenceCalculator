package hexlet.code;

//import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
//import java.util.stream.Collectors;

public class Differ {

    public static ArrayList getListFiles(String str) {
        ArrayList<File> listWithFileNames = new ArrayList<>();

        File f = new File(str);
        for (File s : f.listFiles()) {
            if (s.isFile()) {
                listWithFileNames.add(s);
            } else if (s.isDirectory()) {
                getListFiles(s.getAbsolutePath());
            }
        }
        return listWithFileNames;
    }

    public static String generate(String value1, String value2) throws IOException {
        File file1 = null;
        File file2 = null;
        ArrayList<File> listWithFileNames1 = new ArrayList<>();
        ArrayList<File> listWithFileNames2 = new ArrayList<>();


        if (!(value1.startsWith("./")) && !(value2.startsWith("./"))) {
            listWithFileNames1 = getListFiles("./src/main/resources");
            listWithFileNames2 = getListFiles("./src/main/resources");

            for (File fil : listWithFileNames1) {
                if (fil.getName().equals(value1)) {
                    file1 = fil;
                }
            }
            for (File fil : listWithFileNames2) {
                if (fil.getName().equals(value2)) {
                    file2 = fil;
                }
            }
        } else {
            file1 = Paths.get(value1).toFile();
            file2 = Paths.get(value2).toFile();
        }



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

