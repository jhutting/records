package io.github.jhutting.records;

import java.util.ArrayList;
import java.util.List;

public record BoxWithBuilder(String label, int width, int height, int depth, List<Item> contents) {
    public BoxWithBuilder { // the values are already assigned in the normal constructor!
        try {
            contents.addAll(List.of());
            throw new IllegalArgumentException("Contents should be an immutable list");
        } catch (UnsupportedOperationException uoe) { } // expected behaviour

        if (label == null || label.isBlank()) { // validate business logic
            throw new IllegalArgumentException("The box requires a filled label");
        }
    }

    public BoxWithBuilder withLabel(String label) {
        return new BoxWithBuilder(label, width, height, depth, contents);
    }

    public static class Builder {
        private String label;
        private int width, height, depth;
        private List<Item> contents = new ArrayList<>();

        public Builder(BoxWithBuilder original) {
            this.label = original.label;
            this.width = original.width;
            this.height = original.height;
            this.depth = original.depth;
            contents.addAll(original.contents);
        }

        public Builder addContent(Item item) {
            contents.add(item);
            return this;
        }

        public Builder removeContent(Item item) {
            contents.remove(item);
            return this;
        }

        public Builder replaceContent(List<Item> items) {
            contents = new ArrayList<>(items);
            return this;
        }

        public Builder setLabel(String newLabel) {
            this.label = newLabel;
            return this;
        }

        public Builder setHeight(int newHeight) {
            this.height = newHeight;
            return this;
        }

        public Builder setWidth(int newWidth) {
            this.width = newWidth;
            return this;
        }

        public Builder setDepth(int newDepth) {
            this.depth = newDepth;
            return this;
        }

        public BoxWithBuilder build() {
            return new BoxWithBuilder(label, width, height, depth, List.copyOf(contents));
        }
    }
}
