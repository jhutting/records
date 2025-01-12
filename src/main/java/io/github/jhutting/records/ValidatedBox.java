package io.github.jhutting.records;

import java.util.List;

record ValidatedBox(String label, int width, int height, int depth, List<Item> contents) {
    ValidatedBox { // the values are already assigned in the normal constructor!
        try {
            contents.addAll(List.of());
            throw new IllegalArgumentException("Contents should be an immutable list");
        } catch (UnsupportedOperationException uoe) { } // expected behaviour

        if (label == null || label.isBlank()) { // validate business logic
            throw new IllegalArgumentException("The box requires a filled label");
        }
    }
}
