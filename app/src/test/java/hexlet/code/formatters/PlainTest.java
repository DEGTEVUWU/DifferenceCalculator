package hexlet.code.formatters;

import hexlet.code.CompareMaps;
import hexlet.code.Parser;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;
class PlainTest {
    @Test
    void plainTestJsonWithDeepStructure() throws IOException {
        TreeMap<String, Object> testMap1 = Parser.parser("./src/test/resources/DeepStructure1.json");
        TreeMap<String, Object> testMap2 = Parser.parser("./src/test/resources/DeepStructure2.json");

        var mapWithStatusKey = CompareMaps.compareMaps(testMap1, testMap2);
        var actual = Plain.plain(testMap1, testMap2, mapWithStatusKey);

        var expected = "Property 'chars1' was added with value: [complex value]\n"
                + "Property 'key1' was updated. From 147 to [complex value]\n"
                + "Property 'key2' was added with value: true\n"
                + "Property 'numbers1' was updated. From \'Wow\' to [complex value]\n"
                + "Property 'numbers2' was removed";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void plainTestYmlWithDeepStructure() throws IOException {
        TreeMap<String, Object> testMap1 = Parser.parser("./src/test/resources/DeepStructure1.yml");
        TreeMap<String, Object> testMap2 = Parser.parser("./src/test/resources/DeepStructure2.yml");

        var mapWithStatusKey = CompareMaps.compareMaps(testMap1, testMap2);
        var actual = Plain.plain(testMap1, testMap2, mapWithStatusKey);

        var expected = "Property 'chars1' was added with value: [complex value]\n"
                + "Property 'key1' was updated. From 147 to [complex value]\n"
                + "Property 'key2' was added with value: true\n"
                + "Property 'numbers1' was updated. From \'Wow\' to [complex value]\n"
                + "Property 'numbers2' was removed";

        assertThat(actual).isEqualTo(expected);
    }
  
}