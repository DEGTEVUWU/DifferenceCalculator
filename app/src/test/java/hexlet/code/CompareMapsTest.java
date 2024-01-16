package hexlet.code;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.Assertions.assertThat;

class CompareMapsTest {

    @Test
    void compareMaps() {
        TreeMap<String, Object> map1 = new TreeMap<>();
        TreeMap<String, Object> map2 = new TreeMap<>();
        TreeMap<String, Status> mapResult = new TreeMap<>();

        map1.put("key1", 12);
        map1.put("key2", true);
        map2.put("key2", "WOW!");
        mapResult.put("key1", new Status("key1", "deleted"));
        mapResult.put("key2", new Status("key1", "changed"));

        var actual = CompareMaps.compareMaps(map1, map2);
        var expected = mapResult;
        assertThat(actual.get("key1").isStatus()).isEqualTo(expected.get("key1").isStatus());
        assertThat(actual.get("key2").isStatus()).isEqualTo(expected.get("key2").isStatus());

    }

    @Test
    void compareValues() {
        Object obj1 = true;
        Object obj2 = 147;
        Object obj3 = 147;

        Object obj4 = new int[]{1, 2, 3};
        Object obj5 = new int[]{1, 2, 3};

        var actual1 = CompareMaps.compareValues(obj1, obj2);
        var actual2 = CompareMaps.compareValues(obj2, obj3);
        //var actual3 = CompareMaps.compareValues(obj4, obj5);

        var expected1 = true;

        assertThat(actual1).isFalse();
        assertThat(actual2).isTrue();
        //assertThat(actual3).isEqualTo(expected1);

    }
}
