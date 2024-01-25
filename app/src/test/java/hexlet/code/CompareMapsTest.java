package hexlet.code;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.Assertions.assertThat;

class CompareMapsTest {
    private final int valueFirst = 12;

    @Test
    void compareMaps() {
        TreeMap<String, Object> map1 = new TreeMap<>();
        TreeMap<String, Object> map2 = new TreeMap<>();
        TreeMap<String, Status> mapResult = new TreeMap<>();

        map1.put("key1", valueFirst);
        map1.put("key2", true);
        map2.put("key2", "WOW!");
        mapResult.put("key1", new Status(valueFirst, true, "deleted"));
        mapResult.put("key2", new Status("WOW!", "", "changed"));

        var actual = CompareMaps.compareMaps(map1, map2);
        var expected = mapResult;
        assertThat(actual.get("key1").isStatus()).isEqualTo(expected.get("key1").isStatus());
        assertThat(actual.get("key2").isStatus()).isEqualTo(expected.get("key2").isStatus());

    }
}
