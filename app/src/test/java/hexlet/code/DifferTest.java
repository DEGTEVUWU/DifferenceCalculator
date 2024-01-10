package hexlet.code;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {

    @Test
    void generate() throws IOException {
        File file1 = new File("test1.json");
        File file2 = new File("test2.json");
        var actual = Differ.generate(file1, file2);
        var extended = "{ \n" + "    host=hexlet.io\n" + "  - verbose=true\n" + "}";
        assertThat(actual).isEqualTo(extended);

    }
}