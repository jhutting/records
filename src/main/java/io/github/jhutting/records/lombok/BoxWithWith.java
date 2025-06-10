package io.github.jhutting.records.lombok;

import io.github.jhutting.records.Item;
import lombok.Value;
import lombok.With;

import java.util.List;

@Value
@With
public class BoxWithWith {
    String label;
    int width;
    int height;
    int depth;
    List<Item> contents;
}
