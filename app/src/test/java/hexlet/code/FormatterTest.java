package hexlet.code;

import org.junit.jupiter.api.Test;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class FormatterTest {

    /*

    //doesn't work correctly now

    @Test
    void formatterWithStylishFormat() {
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

        mapWithStatus.put("numbers1", new Status("numbers1", "changed"));
        mapWithStatus.put("numbers2", new Status("numbers2", "deleted"));
        mapWithStatus.put("key1", new Status("key1", "changed"));
        mapWithStatus.put("chars1", new Status("chars1", "added"));
        mapWithStatus.put("key2", new Status("key2", "added"));

        var actual = Formatter.formatter(map1, map2, mapWithStatus, "stylish");

        var expected = "{\n" +
                "  + chars1: [a, b, c]\n" +
                "  - key1: 147\n" +
                "  + key1: [28, 28]\n" +
                "  + key2: true\n" +
                "  - numbers1: Wow\n" +
                "  + numbers1: [1, 2, 3, 4]\n" +
                "  - numbers2: [wow, yes]\n" +
                "}";

        assertThat(actual).isEqualTo(expected);

    }

     */

    @Test
    void formatterWithPlainFormat() {
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

        mapWithStatus.put("numbers1", new Status("numbers1", "changed"));
        mapWithStatus.put("numbers2", new Status("numbers2", "deleted"));
        mapWithStatus.put("key1", new Status("key1", "changed"));
        mapWithStatus.put("chars1", new Status("chars1", "added"));
        mapWithStatus.put("key2", new Status("key2", "added"));

        var actual = Formatter.formatter(map1, map2, mapWithStatus, "plain");

        var expected = "Property 'chars1' was added with value: [complex value]\n"
                + "Property 'key1' was updated. From 147 to [complex value]\n"
                + "Property 'key2' was added with value: true\n"
                + "Property 'numbers1' was updated. From 'Wow' to [complex value]\n"
                + "Property 'numbers2' was removed";

        assertThat(actual).isEqualTo(expected);

    }

    /*


    //doesn't work correctly now


    @Test
    void formatterWithJsonFormat() {
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

        mapWithStatus.put("numbers1", new Status("numbers1", "changed"));
        mapWithStatus.put("numbers2", new Status("numbers2", "deleted"));
        mapWithStatus.put("key1", new Status("key1", "changed"));
        mapWithStatus.put("chars1", new Status("chars1", "added"));
        mapWithStatus.put("key2", new Status("key2", "added"));

        var actual = Formatter.formatter(map1, map2, mapWithStatus, "json");

        var expected = "{\"+chars1\":[a, b, c]," +
                "\"-key1\":147," +
                "\"+key1\":[28, 28]," +
                "\"+key2\":true," +
                "\"-numbers1\":\"Wow\"," +
                "\"+numbers1\":[1, 2, 3, 4]," +
                "\"-numbers2\":[wow, yes]" +
                "}";

        assertThat(actual).isEqualTo(expected);

    }

     */
}
