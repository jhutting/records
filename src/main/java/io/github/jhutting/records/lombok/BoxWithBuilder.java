package io.github.jhutting.records.lombok;

import io.github.jhutting.records.Item;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder(toBuilder = true)
public class BoxWithBuilder {
    String label;
    int width;
    int height;
    int depth;
    List<Item> contents;
}
