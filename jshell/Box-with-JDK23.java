record Item(String description) {}

record Box(String label, int width, int height, int depth, List<Item> contents) {}

Box orig = new Box("example", 210, 297, 100, new ArrayList<>());

// JEP-468, requires --enable-preview and JDK 23
Box altered = orig with { label="changeme");
