package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeMap;

public class Parser {
    public static TreeMap<String, Object> parser(String path) throws IOException {
        File file = null;
        ArrayList<File> listWithFileNames = new ArrayList<>();

        if (!(path.startsWith("./"))) {
            listWithFileNames = getListFiles("./src/main/resources");

            for (File fil : listWithFileNames) {
                if (fil.getName().equals(path)) {
                    file = fil;
                }
            }
        } else {
            file = Paths.get(path).toFile();
        }

        TreeMap<String, Object> map = new TreeMap<>();
        ObjectMapper objectMapperJson = new ObjectMapper();
        ObjectMapper objectMapperYml = new YAMLMapper();

        if (path.endsWith("json")) {
            map = objectMapperJson.readValue(file, TreeMap.class);
        }
        if (path.endsWith("yml")) {
            map = objectMapperYml.readValue(file, TreeMap.class);
        }
        return  map;
    }



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
}
