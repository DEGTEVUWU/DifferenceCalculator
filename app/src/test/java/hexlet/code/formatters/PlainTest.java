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
class PlainTest {
    private static String result;
    private final int valueSecond = 147;

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
        result = readFixture("result_deep_structure_plain.txt");
    }
    @Test
    void jsonFormatTest() throws Exception {
        String content1 = Differ.readFile("./src/test/resources/fixtures/DeepStructureTest1.json");
        String content2 = Differ.readFile("./src/test/resources/fixtures/DeepStructureTest2.json");
        String format = Differ.getDataFormat("./src/test/resources/fixtures/DeepStructureTest2.json");
        TreeMap<String, Object> map1 = Parser.parse(content1, format);
        TreeMap<String, Object> map2 = Parser.parse(content2, format);

        var mapWithStatusKey = CompareMaps.compareMaps(map1, map2);
        var actual = Plain.render(mapWithStatusKey);

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
        var actual = Plain.render(mapWithStatusKey);

        var expected = result;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void propertyValue() {
        Object obj1 = null;
        Object obj2 = true;
        Object obj3 = valueSecond;
        Object obj4 = "Some string";

        var actual1 = Plain.propertyValue(obj1);
        var actual2 = Plain.propertyValue(obj2);
        var actual3 = Plain.propertyValue(obj3);
        var actual4 = Plain.propertyValue(obj4);

        var expected1 = "null";
        var expected2 = "true";
        var expected3 = "147";
        var expected4 = "\'Some string\'";

        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
        assertThat(actual3).isEqualTo(expected3);
        assertThat(actual4).isEqualTo(expected4);

    }
}
