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

        //File file1 = new File("test1.json");
        //File file2 = new File("test2.json");
        var actual = Differ.generate(value1, value2);
        var extended = "{ \n" + "    host=hexlet.io\n" + "  - verbose=true\n" + "}";
        assertThat(actual).isEqualTo(extended);

    }
}
