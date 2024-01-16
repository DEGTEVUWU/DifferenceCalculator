package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StatusTest {

    @Test
    void getValue() {
        var value1 = new Status("value1", "added");
        assertThat(value1.getValue()).isEqualTo("value1");
    }

    @Test
    void isStatus() {
        var value1 = new Status("value1", "unchanged");
        var value2 = new Status("value2", "changed");
        var value3 = new Status("value3", "deleted");
        var value4 = new Status("value4", "added");

        assertThat(value1.isStatus()).isEqualTo("unchanged");
        assertThat(value2.isStatus()).isEqualTo("changed");
        assertThat(value3.isStatus()).isEqualTo("deleted");
        assertThat(value4.isStatus()).isEqualTo("added");

    }
}
