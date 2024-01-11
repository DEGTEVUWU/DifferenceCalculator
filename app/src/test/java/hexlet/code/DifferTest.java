package hexlet.code;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {

    @Test
    void generate() throws IOException {
        String value1 = "./src/test/resources/test1.json";
        String value2 = "./src/test/resources/test2.json";

        var actual = Differ.generate(value1, value2);
        var extended = "{ \n" + "    host=hexlet.io\n" + "  - verbose=true\n" + "}";
        assertThat(actual).isEqualTo(extended);

    }

    @Test
    void generateVoid() throws IOException {
        String value1 = "./src/test/resources/voidFile1.json";
        String value2 = "./src/test/resources/voidFile1.json";

        var actual = Differ.generate(value1, value2);
        var extended = "{ \n}";
        assertThat(actual).isEqualTo(extended);

    }
}
