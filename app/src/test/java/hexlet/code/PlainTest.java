package hexlet.code;
import static org.junit.jupiter.api.Assertions.*;

import com.sun.source.tree.Tree;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;
public class PlainTest {
    @Test
    void plainJson() throws IOException {
        TreeMap<String, Object> testMap1 = Parser.parser("./src/test/resources/test1.json");
        TreeMap<String, Object> testMap2 = Parser.parser("./src/test/resources/test2.json");

        var mapWithStatusKey = CompareMaps.compareMaps(testMap1, testMap2);
        var actual = Plain.plain(testMap1, testMap2, mapWithStatusKey);

        var expected = "\nProperty 'verbose' was removed";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void plainYml() throws IOException {
        TreeMap<String, Object> testMap1 = Parser.parser("./src/test/resources/test2.yml");
        TreeMap<String, Object> testMap2 = Parser.parser("./src/test/resources/test3.yml");

        var mapWithStatusKey = CompareMaps.compareMaps(testMap1, testMap2);
        var actual = Plain.plain(testMap1, testMap2, mapWithStatusKey);

        var expected = "\nProperty 'follow' was added with value: false";
        assertThat(actual).isEqualTo(expected);
    }
}
