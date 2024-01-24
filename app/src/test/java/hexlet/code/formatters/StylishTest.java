package hexlet.code.formatters;

import hexlet.code.CompareMaps;
import hexlet.code.Differ;
import hexlet.code.Parser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
    void jsonFormatTest() throws Exception {
        String content1 = Differ.readFile("./src/test/resources/fixtures/DeepStructureTest1.json");
        String content2 = Differ.readFile("./src/test/resources/fixtures/DeepStructureTest2.json");
        String format = Differ.getDataFormat("./src/test/resources/fixtures/DeepStructureTest2.json");
        TreeMap<String, Object> map1 = Parser.parse(content1, format);
        TreeMap<String, Object> map2 = Parser.parse(content2, format);

        var mapWithStatusKey = CompareMaps.compareMaps(map1, map2);
        var actual = Stylish.render(mapWithStatusKey);

        var expected = result;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void ymlFormatTest() throws Exception {
        String content1 = Differ.readFile("./src/test/resources/fixtures/DeepStructureTest1.json");
        String content2 = Differ.readFile("./src/test/resources/fixtures/DeepStructureTest2.json");
        String format = Differ.getDataFormat("./src/test/resources/fixtures/DeepStructureTest2.json");
        TreeMap<String, Object> map1 = Parser.parse(content1, format);
        TreeMap<String, Object> map2 = Parser.parse(content2, format);

        var mapWithStatusKey = CompareMaps.compareMaps(map1, map2);
        var actual = Stylish.render(mapWithStatusKey);

        var expected = result;

        assertThat(actual).isEqualTo(expected);
    }
}
