package io.github.jhutting.records.lombok;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class LomBoxTest {

    @Test
    void outOfTheBoxMethods() {
        LomBox box = new LomBox("Example", 210, 297, 100, new ArrayList<>());

        assertThat(box.hashCode()).isEqualTo(2005347147);
        assertThat(box).hasToString("LomBox(label=Example, width=210, height=297, depth=100, contents=[])");
        assertThat(box.equals(new LomBox("Example", 210, 297, 100, new ArrayList<>()))).isTrue();
    }

}
