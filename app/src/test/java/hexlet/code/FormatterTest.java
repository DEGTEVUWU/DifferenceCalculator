package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class FormatterTest {
    private static String resultPlain;
    private static String resultStylish;
    private static String resultJson;


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
        resultPlain = readFixture("result_deep_structure_plain.txt");
        resultStylish = readFixture("result_deep_structure_stylish.txt");
        resultJson = readFixture("result_deep_structure.json");

    }



/*
  @Test
    void formatterWithStylishFormat() throws JsonProcessingException {
        TreeMap<String, Object> map1 = new TreeMap<>();
        TreeMap<String, Object> map2 = new TreeMap<>();
        TreeMap<String, Status> mapWithStatus = new TreeMap<>();

        map1.put("numbers1", "Wow");
        map1.put("numbers2", new String[]{"wow", "yes"});
        map1.put("key1", 147);

        map2.put("numbers1", new int[]{1, 2, 3, 4});
        map2.put("chars1", new String[]{"a", "b", "c"});
        map2.put("key1", new int[]{28, 28});
        map2.put("key2", true);

        mapWithStatus.put("numbers1", new Status("Wow", new int[]{1, 2, 3, 4}, "changed"));
        mapWithStatus.put("numbers2", new Status(new String[]{"wow", "yes"}, null, "deleted"));
        mapWithStatus.put("key1", new Status(147, new int[]{28, 28}, "changed"));
        mapWithStatus.put("chars1", new Status(null, new String[]{"a", "b", "c"}, "added"));
        mapWithStatus.put("key2", new Status(null, true, "added"));

        var actual = Formatter.formatter(mapWithStatus, "stylish");

        var expected = resultStylish;

        assertThat(actual).isEqualTo(expected);

    }


 */


    @Test
    void formatterWithPlainFormat() throws JsonProcessingException {
        TreeMap<String, Object> map1 = new TreeMap<>();
        TreeMap<String, Object> map2 = new TreeMap<>();
        TreeMap<String, Status> mapWithStatus = new TreeMap<>();

        map1.put("numbers1", "Wow");
        map1.put("numbers2", new String[]{"wow", "yes"});
        map1.put("key1", 147);

        map2.put("numbers1", new int[]{1, 2, 3, 4});
        map2.put("chars1", new String[]{"a", "b", "c"});
        map2.put("key1", new int[]{28, 28});
        map2.put("key2", true);

        mapWithStatus.put("numbers1", new Status("Wow", new int[]{1, 2, 3, 4}, "changed"));
        mapWithStatus.put("numbers2", new Status(new String[]{"wow", "yes"}, null, "deleted"));
        mapWithStatus.put("key1", new Status(147, new int[]{28, 28}, "changed"));
        mapWithStatus.put("chars1", new Status(null, new String[]{"a", "b", "c"}, "added"));
        mapWithStatus.put("key2", new Status(null, true, "added"));

        var actual = Formatter.formatter(mapWithStatus, "plain");

        var expected = resultPlain;

        assertThat(actual).isEqualTo(expected);

    }










    @Test
    void formatterWithJsonFormat() throws JsonProcessingException {
        TreeMap<String, Object> map1 = new TreeMap<>();
        TreeMap<String, Object> map2 = new TreeMap<>();
        TreeMap<String, Status> mapWithStatus = new TreeMap<>();

        map1.put("numbers1", "Wow");
        map1.put("numbers2", new String[]{"wow", "yes"});
        map1.put("key1", 147);

        map2.put("numbers1", new int[]{1, 2, 3, 4});
        map2.put("chars1", new String[]{"a", "b", "c"});
        map2.put("key1", new int[]{28, 28});
        map2.put("key2", true);

        mapWithStatus.put("numbers1", new Status("Wow", new int[]{1, 2, 3, 4}, "changed"));
        mapWithStatus.put("numbers2", new Status(new String[]{"wow", "yes"}, null, "deleted"));
        mapWithStatus.put("key1", new Status(147, new int[]{28, 28}, "changed"));
        mapWithStatus.put("chars1", new Status(null, new String[]{"a", "b", "c"}, "added"));
        mapWithStatus.put("key2", new Status(null, true, "added"));

        var actual = Formatter.formatter(mapWithStatus, "json");

        var expected = resultJson;

        assertThat(actual).isEqualTo(expected);

    }
}
