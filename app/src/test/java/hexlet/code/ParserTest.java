package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    @Test
    void parser() throws IOException {
        TreeMap<String, Object> actual = Parser.parser("./src/test/resources/DeepStructure1.json");
        TreeMap<String, Object> expected = new TreeMap<>();

        expected.put("numbers1", "Wow");
        expected.put("numbers2", new String[]{"wow", "yes"});
        expected.put("key1", 147);

        String valueFromActual = Arrays.toString(new Object[]{actual.get("numbers1")});
        String valueFromExpected = Arrays.toString(new Object[]{expected.get("numbers1")});

        assertThat(actual.get("key1").toString()).isEqualTo(expected.get("key1").toString());
        assertThat(actual.get("numbers1").toString()).isEqualTo(expected.get("numbers1").toString());
        assertThat(valueFromActual).isEqualTo(valueFromExpected);

    }

    @Test
    void getListFiles() throws IOException {
        ArrayList<File> actual = Parser.getListFiles("./src/main/resources");
        ArrayList<File> expected = new ArrayList<>();
        File file1 = Paths.get("./src/main/resources/file4.json").toFile();
        File file2 = Paths.get("./src/main/resources/file3.yml").toFile();
        File file3 = Paths.get("./src/main/resources/file1.json").toFile();
        File file4 = Paths.get("./src/main/resources/file2.yml").toFile();
        File file5 = Paths.get("./src/main/resources/file2.json").toFile();
        File file6 = Paths.get("./src/main/resources/file3.json").toFile();
        File file7 = Paths.get("./src/main/resources/file1.yml").toFile();
        File file8 = Paths.get("./src/main/resources/file4.yml").toFile();

        expected.add(file1);
        expected.add(file2);
        expected.add(file3);
        expected.add(file4);
        expected.add(file5);
        expected.add(file6);
        expected.add(file7);
        expected.add(file8);

        assertThat(actual.toString()).isEqualTo(expected.toString());

    }
}
