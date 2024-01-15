package hexlet.code;

import static org.junit.jupiter.api.Assertions.*;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    @Test
    void parser() throws IOException {
        String path = "./src/test/resources/DeepStructure1.json";
        TreeMap<String, Object> actual = Parser.parser("./src/test/resources/DeepStructure1.json");
        TreeMap<String, Object> expected = new TreeMap<>();
        expected.put("numbers1", new int[]{1, 2, 3, 4});
        expected.put("numbers2", new String[]{"wow", "yes"});
        assertThat(actual.equals(expected));

    }

    @Test
    void getListFiles() throws IOException {
        List<String> actual = Parser.getListFiles("./src/main/resources");
        List<String> expected = new ArrayList<>();
        expected.add("./src/main/resources/file4.json");

        expected.add("./src/main/resources/file3.yml");
        expected.add("./src/main/resources/file1.json");
        expected.add("./src/main/resources/file2.yml");
        expected.add("./src/main/resources/file2.json");
        expected.add("./src/main/resources/file3.json");
        expected.add("./src/main/resources/file1.yml");
        expected.add("./src/main/resources/file4.yml");

        assertThat(actual.equals(expected));

    }
}