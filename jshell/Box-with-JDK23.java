record Item(String description) {}

record Box(String label, int width, int height, int depth, List<Item> contents) {}

Box originalBox = new Box("example", 210, 297, 100, List.of());

// JEP-468, requires --enable-preview, but wasn't added to JDK 23, 24 or even 25 yet.
Box altered = originalBox with { label = "changeme" };
