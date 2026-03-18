package io.github.jhutting.records;

import java.util.List;

record BoxWithSemantics(String label, int width, int height, int depth, List<Item> contents) {
    BoxWithSemantics { // the values are already assigned in the normal constructor!
        contents = List.copyOf(contents);

        if (label == null || label.isBlank()) { // validate business logic
            throw new IllegalArgumentException("The box requires a filled label");
        }
    }

    public BoxWithSemantics replaceContents(String newLabel, List<Item> newContents) {
        return new BoxWithSemantics(newLabel, width, height, depth, newContents);
    }

    public BoxWithSemantics replaceContents(List<Item> newContents) {
        return replaceContents(label, newContents);
    }
}
