package module1.arrays.sumofinfinitearray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testOne() {

        final List<List<Long>> queries = Arrays.asList(Arrays.asList(1L, 3L), Arrays.asList(1L, 5L));
        final List<Integer> results = Solution.sumInRanges(new int[]{1, 2, 3}, 3, queries, 2);
        assertEquals(6, results.get(0));
        assertEquals(9, results.get(1));
    }

    @Test
    void testTwo() {

        final List<List<Long>> queries = Arrays.asList(Arrays.asList(1L, 5L), Arrays.asList(10L, 13L), Arrays.asList(7L, 11L));
        final List<Integer> results = Solution.sumInRanges(new int[]{5, 2, 6, 9}, 4, queries, 3);
        assertEquals(27, results.get(0));
        assertEquals(22, results.get(1));
        assertEquals(28, results.get(2));
    }
}
