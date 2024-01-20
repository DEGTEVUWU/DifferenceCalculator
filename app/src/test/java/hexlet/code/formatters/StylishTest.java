package hexlet.code.formatters;

import hexlet.code.CompareMaps;
import hexlet.code.Parser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class StylishTest {
    private static String result;
    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }
    @BeforeAll
    public static void beforeAll() throws Exception {
        result = readFixture("result_deep_structure_stylish.txt");
    }
    @Test
    void jsonFormatTest() throws IOException {
        TreeMap<String, Object> testMap1 = Parser.parser("./src/test/resources/fixtures/DeepStructureTest1.json");
        TreeMap<String, Object> testMap2 = Parser.parser("./src/test/resources/fixtures/DeepStructureTest2.json");

        var mapWithStatusKey = CompareMaps.compareMaps(testMap1, testMap2);
        var actual = Stylish.stylish(mapWithStatusKey);

        var expected = result;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void ymlFormatTest() throws IOException {
        TreeMap<String, Object> testMap1 = Parser.parser("./src/test/resources/fixtures/DeepStructureTest1.yml");
        TreeMap<String, Object> testMap2 = Parser.parser("./src/test/resources/fixtures/DeepStructureTest2.yml");

        var mapWithStatusKey = CompareMaps.compareMaps(testMap1, testMap2);
        var actual = Stylish.stylish(mapWithStatusKey);

        var expected = result;

        assertThat(actual).isEqualTo(expected);
    }
}
