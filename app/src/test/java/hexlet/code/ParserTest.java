package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {
    private final int valueSecond = 147;

    @Test
    void parser() throws IOException {
        TreeMap<String, Object> actual = Parser.parser("./src/test/resources/fixtures/DeepStructureTest1.json");
        TreeMap<String, Object> expected = new TreeMap<>();

        expected.put("numbers1", "Wow");
        expected.put("numbers2", new String[]{"wow", "yes"});
        expected.put("key1", valueSecond);

        String valueFromActual = Arrays.toString(new Object[]{actual.get("numbers1")});
        String valueFromExpected = Arrays.toString(new Object[]{expected.get("numbers1")});

        assertThat(actual.get("key1").toString()).isEqualTo(expected.get("key1").toString());
        assertThat(actual.get("numbers1").toString()).isEqualTo(expected.get("numbers1").toString());
        assertThat(valueFromActual).isEqualTo(valueFromExpected);

    }

    @Test
    void parserTest2() throws IOException {
        TreeMap<String, Object> actual = Parser.parser("./src/test/resources/fixtures/DeepStructureTest1.json");
        TreeMap<String, Object> expected = new TreeMap<>();

        assertThat(actual).isNotEmpty();

    }
}
