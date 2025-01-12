package io.github.jhutting.records;

import java.util.List;

public record Box(String label, int width, int height, int depth, List<Item> contents) { }
