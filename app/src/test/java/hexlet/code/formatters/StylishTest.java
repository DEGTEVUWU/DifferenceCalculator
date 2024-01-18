package hexlet.code.formatters;

import hexlet.code.CompareMaps;
import hexlet.code.Parser;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class StylishTest {
    /*

    @Test
    void stilishJsonWithDeepStructure() throws IOException {
        TreeMap<String, Object> testMap1 = Parser.parser("./src/test/resources/DeepStructure1.json");
        TreeMap<String, Object> testMap2 = Parser.parser("./src/test/resources/DeepStructure2.json");

        var mapWithStatusKey = CompareMaps.compareMaps(testMap1, testMap2);
        var actual = Stylish.stylish(testMap1, testMap2, mapWithStatusKey);

        var expected = "{\n"
                + "  + chars1: [a, b, c]\n"
                + "  - key1: 147\n"
                + "  + key1: [28, 28]\n"
                + "  + key2: true\n"
                + "  - numbers1: Wow\n"
                + "  + numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [wow, yes]\n"
                + "}";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void stilishYmlWithDeepStructure() throws IOException {
        TreeMap<String, Object> testMap1 = Parser.parser("./src/test/resources/DeepStructure1.yml");
        TreeMap<String, Object> testMap2 = Parser.parser("./src/test/resources/DeepStructure2.yml");

        var mapWithStatusKey = CompareMaps.compareMaps(testMap1, testMap2);
        var actual = Stylish.stylish(testMap1, testMap2, mapWithStatusKey);

        var expected = "{\n"
                + "  + chars1: [a, b, c]\n"
                + "  - key1: 147\n"
                + "  + key1: [28, 28]\n"
                + "  + key2: true\n"
                + "  - numbers1: Wow\n"
                + "  + numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [wow, yes]\n"
                + "}";

        assertThat(actual).isEqualTo(expected);
    }

     */
}
