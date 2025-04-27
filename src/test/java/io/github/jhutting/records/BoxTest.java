package io.github.jhutting.records;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BoxTest {

    @Test
    void outOfTheBoxMethods() {
        Box box = new Box("Example", 210, 297, 100, new ArrayList<>());

        assertThat(box.hashCode()).isEqualTo(-271068866);
        assertThat(box).hasToString("Box[label=Example, width=210, height=297, depth=100, contents=[]]");
        assertThat(box.equals(new Box("Example", 210, 297, 100, new ArrayList<>()))).isTrue();
    }

    @Test
    void mutableArrayList() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Toy car"));

        Box box = new Box("Toys", 210, 297, 100, items);

        // records are immutable, but the contained ArrayList is not.
        items.add(new Item("Lego brick")); // adding to the original list
        assertThat(box.contents().getLast().label()).isEqualTo("Lego brick");

        box.contents().add(new Item("Another late entry")); // and even to the one in the record
        assertThat(box.contents().getLast().label()).isEqualTo("Another late entry");
    }

    @Test
    void mutableUnmodifiableList() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Toy car"));

        Box box = new Box("Toys", 210, 297, 100, Collections.unmodifiableList(items));

        // this is no longer possible with an unmodifiableCollection
        assertThatThrownBy(() -> box.contents().add(new Item("Another late entry")))
                .hasStackTraceContaining("UnmodifiableCollection.add");

        // records are immutable, but the contained ArrayList is not.
        items.add(new Item("Lego brick")); // adding to the original list
        assertThat(box.contents().getLast().label()).isEqualTo("Lego brick");
    }
}