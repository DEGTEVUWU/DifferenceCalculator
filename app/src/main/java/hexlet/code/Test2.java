package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
//import java.util.Map;

public class Test2 {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Test value = mapper.readValue(new File("file1.json"), Test.class);

        //Map<String, Integer> scoreByName = mapper.readValue(jsonSource, Map.class);

    }
}
