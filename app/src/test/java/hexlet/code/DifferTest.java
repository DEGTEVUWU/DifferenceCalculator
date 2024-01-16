package hexlet.code;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {

    @Test
    void generateSimpleJson() throws IOException {
        String value1 = "./src/test/resources/test1.json";
        String value2 = "./src/test/resources/test2.json";

        var actual = Differ.generate(value1, value2);
        var expected = "{\n"
                + "    host: hexlet.io\n"
                + "  - verbose: true\n"
                + "}";
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void generateJsonVoid() throws IOException {
        String value1 = "./src/test/resources/voidFile1.json";
        String value2 = "./src/test/resources/voidFile1.json";

        var actual = Differ.generate(value1, value2);
        var expected = "{\n}";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateSimpleYml() throws IOException {
        String value1 = "./src/test/resources/test1.yml";
        String value2 = "./src/test/resources/test2.yml";

        var actual = Differ.generate(value1, value2);
        var expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "}";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateYmlVoid() throws IOException {
        String value1 = "./src/test/resources/voidTest1.yml";
        String value2 = "./src/test/resources/voidTest2.yml";

        var actual = Differ.generate(value1, value2);
        var expected = "{\n}";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateMethodWithPlainParametersJsonFiles() throws IOException {
        String value1 = "./src/test/resources/DeepStructure1.json";
        String value2 = "./src/test/resources/DeepStructure2.json";

        var actual = Differ.generate(value1, value2, "plain");

        var expected = "Property 'chars1' was added with value: [complex value]\n"
                + "Property 'key1' was updated. From 147 to [complex value]\n"
                + "Property 'key2' was added with value: true\n"
                + "Property 'numbers1' was updated. From 'Wow' to [complex value]\n"
                + "Property 'numbers2' was removed";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateMethodWithPlainParametersYmlFiles() throws IOException {
        String value1 = "./src/test/resources/DeepStructure1.yml";
        String value2 = "./src/test/resources/DeepStructure2.yml";

        var actual = Differ.generate(value1, value2, "plain");

        var expected = "Property 'chars1' was added with value: [complex value]\n"
                + "Property 'key1' was updated. From 147 to [complex value]\n"
                + "Property 'key2' was added with value: true\n"
                + "Property 'numbers1' was updated. From 'Wow' to [complex value]\n"
                + "Property 'numbers2' was removed";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateMethodWithStylishParametersJsonFiles() throws IOException {
        String value1 = "./src/test/resources/DeepStructure1.json";
        String value2 = "./src/test/resources/DeepStructure2.json";

        var actual = Differ.generate(value1, value2, "stylish");

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
    void generateMethodWithStylishParametersYmlFiles() throws IOException {
        String value1 = "./src/test/resources/DeepStructure1.yml";
        String value2 = "./src/test/resources/DeepStructure2.yml";

        var actual = Differ.generate(value1, value2, "stylish");

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
    void generateMethodWithJsonParametersJsonFiles() throws IOException {
        String value1 = "./src/test/resources/DeepStructure1.json";
        String value2 = "./src/test/resources/DeepStructure2.json";

        var actual = Differ.generate(value1, value2, "json");

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
    void generateMethodWithJsonParametersYmlFiles() throws IOException {
        String value1 = "./src/test/resources/DeepStructure1.yml";
        String value2 = "./src/test/resources/DeepStructure2.yml";

        var actual = Differ.generate(value1, value2, "json");

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
    void generateMethodWithDefaultParametersJsonFiles() throws IOException {
        String value1 = "./src/test/resources/DeepStructure1.json";
        String value2 = "./src/test/resources/DeepStructure2.json";

        var actual = Differ.generate(value1, value2);

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
    void generateMethodWithDefaultParametersYmlFiles() throws IOException {
        String value1 = "./src/test/resources/DeepStructure1.yml";
        String value2 = "./src/test/resources/DeepStructure2.yml";

        var actual = Differ.generate(value1, value2);

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
}
