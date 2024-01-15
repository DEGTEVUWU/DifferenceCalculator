package hexlet.code;

import static org.junit.jupiter.api.Assertions.*;

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
        var value2 = new Status("value2", "changed");
        assertThat(value2.isStatus()).isEqualTo("changed");
    }
}