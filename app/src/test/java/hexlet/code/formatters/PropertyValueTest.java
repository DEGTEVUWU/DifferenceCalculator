package hexlet.code.formatters;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PropertyValueTest {

    @Test
    void propertyValue() {
        Object obj1 = null;
        Object obj2 = true;
        Object obj3 = 147;
        Object obj4 = "Some string";
        Object obj5 = new int[]{1, 2, 3, 4};
        Object obj6 = new String[]{"wow", "its", "some", "massive"};
        Object obj7 = new Character[]{};

        var actual1 = PropertyValue.propertyValue(obj1);
        var actual2 = PropertyValue.propertyValue(obj2);
        var actual3 = PropertyValue.propertyValue(obj3);
        var actual4 = PropertyValue.propertyValue(obj4);
        var actual5 = PropertyValue.propertyValue(obj5);
        var actual6 = PropertyValue.propertyValue(obj6);
        var actual7 = PropertyValue.propertyValue(obj7);

        var expected1 = "Simple type";
        var expected2 = "Simple type";
        var expected3 = "Simple type";
        var expected4 = "String type";
        var expected5 = "Composite type";
        var expected6 = "Composite type";
        var expected7 = "Composite type";

        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
        assertThat(actual3).isEqualTo(expected3);
        assertThat(actual4).isEqualTo(expected4);
        assertThat(actual5).isEqualTo(expected5);
        assertThat(actual6).isEqualTo(expected6);
        assertThat(actual7).isEqualTo(expected7);

    }
}
