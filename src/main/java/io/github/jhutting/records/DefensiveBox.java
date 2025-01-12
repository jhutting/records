package io.github.jhutting.records;

import java.util.List;

record DefensiveBox(String label, int width, int height, int depth, List<Item> contents) {
    DefensiveBox {
        // the values are already assigned in the normal constructor!
        // however, they are still treated as variables at this point.
        if (label == null || label.isBlank()) { // validate business logic
            label = "None";
        }

        contents = List.copyOf(contents); // immutable copy
    }
}
