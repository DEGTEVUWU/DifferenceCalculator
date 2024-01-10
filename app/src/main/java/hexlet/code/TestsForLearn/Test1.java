package hexlet.code.TestsForLearn;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        String json2 = "{ \"color\" : \"White\", \"type\" : \"FIAT\" }";

        Car car1 = objectMapper.readValue(json, Car.class);
        System.out.println(car1);

        JsonNode jsonNode = objectMapper.readTree(json2);
        String color = jsonNode.get("color").asText();
        System.out.println(color);

        Car car3 = new Car("yellow", "renault");
        objectMapper.writeValue(new File("car.json"), car3);
        String carAsString = objectMapper.writeValueAsString(car3);
        System.out.println(carAsString);

        //List --->

        String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});
        for (var element : listCar) {
            System.out.println(element.getColor());
            System.out.println(element.getType());

        }


        //Map --->

        String json3 = "{ \"color\" : \"Black\", \"type\" : \"BMW\" , \"color2\" : \"White\", \"type2\" : \"Audi\"}";
        Map<String, Object> map
                = objectMapper.readValue(json3, new TypeReference<Map<String,Object>>(){});
        System.out.println(map);


        //test tutorial from github jackson-databind --->


        Car value1 = objectMapper.readValue("{ \"color\":\"bl\", \"type\":\"bmw\" }", Car.class);
        Car value2 = objectMapper.readValue(new File("car2.json"), Car.class);


        System.out.println(value1);
        System.out.println(value2.getType());
        System.out.println(value2.getColor());

    }
}
