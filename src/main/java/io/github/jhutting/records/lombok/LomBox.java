package io.github.jhutting.records.lombok;

import io.github.jhutting.records.Item;
import lombok.Value;

import java.util.List;

@Value
public class LomBox {
    String label;
    int width;
    int height;
    int depth;
    List<Item> contents;
}
