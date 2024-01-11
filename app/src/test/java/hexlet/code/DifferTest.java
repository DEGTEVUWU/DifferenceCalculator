package hexlet.code;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {

    @Test
    void generateJson() throws IOException {
        String value1 = "./src/test/resources/test1.json";
        String value2 = "./src/test/resources/test2.json";

        var actual = Differ.generate(value1, value2);
        var extended = "{ \n" + "    host=hexlet.io\n" + "  - verbose=true\n" + "}";
        assertThat(actual).isEqualTo(extended);

    }

    @Test
    void generateJsonVoid() throws IOException {
        String value1 = "./src/test/resources/voidFile1.json";
        String value2 = "./src/test/resources/voidFile1.json";

        var actual = Differ.generate(value1, value2);
        var extended = "{ \n}";
        assertThat(actual).isEqualTo(extended);
    }

    @Test
    void generateYml() throws IOException {
        String value1 = "./src/test/resources/test1.yml";
        String value2 = "./src/test/resources/test2.yml";

        var actual = Differ.generate(value1, value2);
        var extended = "{ \n" + "  - follow=false\n" + "    host=hexlet.io\n" + "}";
        assertThat(actual).isEqualTo(extended);
    }

    @Test
    void generateYmlVoid() throws IOException {
        String value1 = "./src/test/resources/voidTest1.yml";
        String value2 = "./src/test/resources/voidTest2.yml";

        var actual = Differ.generate(value1, value2);
        var extended = "{ \n}";
        assertThat(actual).isEqualTo(extended);
    }

}
