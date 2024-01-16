package hexlet.code.formatters;

import hexlet.code.CompareMaps;
import hexlet.code.Parser;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class JsonTest {

    @Test
    void reversToJsonTest() throws IOException {
        TreeMap<String, Object> testMap1 = Parser.parser("./src/test/resources/DeepStructure1.json");
        TreeMap<String, Object> testMap2 = Parser.parser("./src/test/resources/DeepStructure2.json");

        var mapWithStatusKey = CompareMaps.compareMaps(testMap1, testMap2);
        var actual = Json.json(testMap1, testMap2, mapWithStatusKey);

        var expected = "{\"+chars1\":[a, b, c],"
                + "\"-key1\":147,"
                + "\"+key1\":[28, 28],"
                + "\"+key2\":true,"
                + "\"-numbers1\":\"Wow\","
                + "\"+numbers1\":[1, 2, 3, 4],"
                + "\"-numbers2\":[wow, yes]"
                + "}";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void reversToYmlTest() throws IOException {
        TreeMap<String, Object> testMap1 = Parser.parser("./src/test/resources/DeepStructure1.yml");
        TreeMap<String, Object> testMap2 = Parser.parser("./src/test/resources/DeepStructure2.yml");

        var mapWithStatusKey = CompareMaps.compareMaps(testMap1, testMap2);
        var actual = Json.json(testMap1, testMap2, mapWithStatusKey);

        var expected = "{\"+chars1\":[a, b, c],"
                + "\"-key1\":147,"
                + "\"+key1\":[28, 28],"
                + "\"+key2\":true,"
                + "\"-numbers1\":\"Wow\","
                + "\"+numbers1\":[1, 2, 3, 4],"
                + "\"-numbers2\":[wow, yes]"
                + "}";

        assertThat(actual).isEqualTo(expected);
    }
}
