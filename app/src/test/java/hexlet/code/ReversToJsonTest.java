package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class ReversToJsonTest {

    @Test
    void reversToJsonTest() throws IOException {
        TreeMap<String, Object> testMap1 = Parser.parser("./src/test/resources/DeepStructure1.json");
        TreeMap<String, Object> testMap2 = Parser.parser("./src/test/resources/DeepStructure2.json");

        var mapWithStatusKey = CompareMaps.compareMaps(testMap1, testMap2);
        var actual = Json.json(testMap1, testMap2, mapWithStatusKey);

        var expected = "{\"+chars1\":[a, b, c],\"numbers1\":[1, 2, 3, 4],\"-numbers2\":[wow, yes]}";

        assertThat(actual).isEqualTo(expected);
    }

}
