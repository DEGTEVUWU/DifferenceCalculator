package hexlet.code;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {
    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;

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
        resultJson = readFixture("result_json.json");
        resultPlain = readFixture("result_plain.txt");
        resultStylish = readFixture("result_stylish.txt");
    }


    @Test
    void checkingJsonFileInThePlainFormatter() throws IOException {
        String value1 = "./src/test/resources/fixtures/DeepStructureTest1.json";
        String value2 = "./src/test/resources/fixtures/DeepStructureTest2.json";

        var actual = Differ.generate(value1, value2, "plain");

        var expected = resultPlain;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void checkingYmlFileInThePlainFormatter() throws IOException {
        String value1 = "./src/test/resources/fixtures/DeepStructureTest1.yml";
        String value2 = "./src/test/resources/fixtures/DeepStructureTest2.yml";

        var actual = Differ.generate(value1, value2, "plain");

        var expected = resultPlain;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void checkingJsonFileInTheStylishFormatter() throws IOException {
        String value1 = "./src/test/resources/fixtures/DeepStructureTest1.json";
        String value2 = "./src/test/resources/fixtures/DeepStructureTest2.json";

        var actual = Differ.generate(value1, value2, "stylish");

        var expected = resultStylish;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void checkingYmlFileInTheStylishFormatter() throws IOException {
        String value1 = "./src/test/resources/fixtures/DeepStructureTest1.yml";
        String value2 = "./src/test/resources/fixtures/DeepStructureTest2.yml";

        var actual = Differ.generate(value1, value2, "stylish");

        var expected = resultStylish;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void checkingJsonFileInTheJsonFormatter() throws IOException {
        String value1 = "./src/test/resources/fixtures/DeepStructureTest1.json";
        String value2 = "./src/test/resources/fixtures/DeepStructureTest2.json";

        var actual = Differ.generate(value1, value2, "json");

        var expected = resultJson;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void checkingYmlFileInTheJsonFormatter() throws IOException {
        String value1 = "./src/test/resources/fixtures/DeepStructureTest1.yml";
        String value2 = "./src/test/resources/fixtures/DeepStructureTest2.yml";

        var actual = Differ.generate(value1, value2, "json");

        var expected = resultJson;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void checkingJsonFileInTheDefaultFormatter() throws IOException {
        String value1 = "./src/test/resources/fixtures/DeepStructureTest1.json";
        String value2 = "./src/test/resources/fixtures/DeepStructureTest2.json";

        var actual = Differ.generate(value1, value2);

        var expected = resultStylish;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void checkingYmlFileInTheDefaultFormatter() throws IOException {
        String value1 = "./src/test/resources/fixtures/DeepStructureTest1.yml";
        String value2 = "./src/test/resources/fixtures/DeepStructureTest2.yml";

        var actual = Differ.generate(value1, value2);

        var expected = resultStylish;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void checkingGetDataFormatWithJsonFormat() throws IOException {
        String value = "DeepStructure1.json";

        var actual = Differ.getDataFormat(value);

        var expected = "json";

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void checkingGetDataFormatWithYmlFormat() throws IOException {
        String value = "DeepStructure1.yml";

        var actual = Differ.getDataFormat(value);

        var expected = "yml";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void checkingGetDataFormatWithUncheckingFormat() throws IOException {
        String value = "DeepStructure";

        var actual = Differ.getDataFormat(value);

        var expected = "";

        assertThat(actual).isEqualTo(expected);
    }
}
