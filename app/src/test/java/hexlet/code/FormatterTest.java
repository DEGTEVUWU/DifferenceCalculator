package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class FormatterTest {
    private static String resultPlain;
    private static String resultStylish;
    private static String resultJson;


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
        resultPlain = readFixture("result_deep_structure_plain.txt");
        resultStylish = readFixture("result_deep_structure_stylish.txt");
        resultJson = readFixture("result_deep_structure.json");

    }
    @Test
    void formatterWithStylishFormat() throws Exception {
        TreeMap<String, Object> map1 = Differ.getData("./src/test/resources/fixtures/DeepStructureTest1.json");
        TreeMap<String, Object> map2 = Differ.getData("./src/test/resources/fixtures/DeepStructureTest2.json");

        var mapWithStatusKey = CompareMaps.compareMaps(map1, map2);
        var actual = Formatter.formatter(mapWithStatusKey, "stylish");

        var expected = resultStylish;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void formatterWithPlainFormat() throws Exception {
        TreeMap<String, Object> map1 = Differ.getData("./src/test/resources/fixtures/DeepStructureTest1.json");
        TreeMap<String, Object> map2 = Differ.getData("./src/test/resources/fixtures/DeepStructureTest2.json");

        var mapWithStatusKey = CompareMaps.compareMaps(map1, map2);
        var actual = Formatter.formatter(mapWithStatusKey, "plain");

        var expected = resultPlain;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void formatterWithJsonFormat() throws Exception {
        TreeMap<String, Object> map1 = Differ.getData("./src/test/resources/fixtures/DeepStructureTest1.json");
        TreeMap<String, Object> map2 = Differ.getData("./src/test/resources/fixtures/DeepStructureTest2.json");

        var mapWithStatusKey = CompareMaps.compareMaps(map1, map2);
        var actual = Formatter.formatter(mapWithStatusKey, "json");

        var expected = resultJson;

        assertThat(actual).isEqualTo(expected);

    }
}
