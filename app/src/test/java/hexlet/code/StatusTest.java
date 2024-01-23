package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StatusTest {

    @Test
    void oldValueTest() {
        var value1 = new Status("oldValue", "newValue", "changed");
        assertThat(value1.getOldValue()).isEqualTo("oldValue");
    }
    @Test
    void newValueTest() {
        var value1 = new Status("oldValue", "newValue", "changed");
        assertThat(value1.getNewValue()).isEqualTo("newValue");
    }

    @Test
    void isStatusTest() {
        var value1 = new Status("oldValue", "newValue", "unchanged");
        var value2 = new Status("oldValue", "newValue", "changed");
        var value3 = new Status("oldValue", "newValue", "deleted");
        var value4 = new Status("oldValue", "newValue", "added");

        assertThat(value1.isStatus()).isEqualTo("unchanged");
        assertThat(value2.isStatus()).isEqualTo("changed");
        assertThat(value3.isStatus()).isEqualTo("deleted");
        assertThat(value4.isStatus()).isEqualTo("added");
        //
    }
}
