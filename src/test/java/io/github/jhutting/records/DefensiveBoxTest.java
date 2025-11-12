package io.github.jhutting.records;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.slf4j.LoggerFactory.getLogger;

class DefensiveBoxTest {
    private static final Logger log = getLogger(DefensiveBoxTest.class);
    /**
     * copyOf should return the pointer instead of copying all elements all over again when called on an already Immutable/Unmodifiable List, this testcase aims to confirm that.
     */
    @Test
    void copyOfPerformanceTest() {
        final Random rng = new Random(42L); // just in case we add a seed for reproducibility
        final List<Item> contents = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            contents.add(new Item("Content-%d".formatted(rng.nextInt()), rng.nextInt()));
        }
        final long startTime = System.nanoTime();
        final DefensiveBox firstSlowAttempt = new DefensiveBox("firstSlowAttempt", 210, 297, 100, contents);
        final long endTime = System.nanoTime();

        final long secondStartTime = System.nanoTime();
        final DefensiveBox second = new DefensiveBox("second should be faster", 210, 297, 100, firstSlowAttempt.contents());
        final long secondEndTime = System.nanoTime();

        final long thirdStartTime = System.nanoTime();
        final DefensiveBox third = new DefensiveBox("third should be faster", 210, 297, 100, firstSlowAttempt.contents());
        final long thirdEndTime = System.nanoTime();

        log.info("{} took {}ns", firstSlowAttempt.label(), Duration.ofNanos(endTime - startTime).toNanos());
        log.info("{} took {}ns", second.label(), Duration.ofNanos(secondEndTime - secondStartTime).toNanos());
        log.info("{} took {}ns", third.label(), Duration.ofNanos(thirdEndTime - thirdStartTime).toNanos());
    }
}
