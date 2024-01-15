package hexlet.code;
import hexlet.code.formatters.Stylish;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {

    @Test
    void generateJson() throws IOException {
        String value1 = "./src/test/resources/test1.json";
        String value2 = "./src/test/resources/test2.json";

        var actual = Differ.generate(value1, value2);
        var expected = "{ \n" + "    host: hexlet.io\n" + "  - verbose: true\n" + "}";
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void generateJsonVoid() throws IOException {
        String value1 = "./src/test/resources/voidFile1.json";
        String value2 = "./src/test/resources/voidFile1.json";

        var actual = Differ.generate(value1, value2);
        var expected = "{ \n}";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateYml() throws IOException {
        String value1 = "./src/test/resources/test1.yml";
        String value2 = "./src/test/resources/test2.yml";

        var actual = Differ.generate(value1, value2);
        var expected = "{ \n" + "  - follow: false\n" + "    host: hexlet.io\n" + "}";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateYmlVoid() throws IOException {
        String value1 = "./src/test/resources/voidTest1.yml";
        String value2 = "./src/test/resources/voidTest2.yml";

        var actual = Differ.generate(value1, value2);
        var expected = "{ \n}";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void stylish() throws IOException {
        TreeMap<String, Object> testMap1 = Parser.parser("./src/test/resources/DeepStructure1.json");
        TreeMap<String, Object> testMap2 = Parser.parser("./src/test/resources/DeepStructure2.json");


        var mapWithStatusKey = CompareMaps.compareMaps(testMap1, testMap2);
        var actual = Stylish.stylish(testMap1, testMap2, mapWithStatusKey);
        var expected = "{ \n" + "  + chars1: [a, b, c]\n" + "    numbers1: [1, 2, 3, 4]\n" + "  - numbers2: [wow, yes]\n" + "}";
        assertThat(actual).isEqualTo(expected);

    }
}
