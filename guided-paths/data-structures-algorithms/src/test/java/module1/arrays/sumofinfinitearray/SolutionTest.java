package module1.arrays.sumofinfinitearray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@FunctionalInterface
interface Solution {

    List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q);
}

class SolutionTest {

    @ParameterizedTest
    @MethodSource("provideSolutions")
    void testOne(Solution solution) {

        final List<List<Long>> queries = Arrays.asList(Arrays.asList(1L, 3L), Arrays.asList(1L, 5L));
        final List<? extends Number> results = solution.sumInRanges(new int[]{1, 2, 3}, 3, queries, 2);
        assertEquals(6, results.get(0));
        assertEquals(9, results.get(1));
    }

    @ParameterizedTest
    @MethodSource("provideSolutions")
    void testTwo(Solution solution) {

        final List<List<Long>> queries = Arrays.asList(Arrays.asList(1L, 5L), Arrays.asList(10L, 13L), Arrays.asList(7L, 11L));
        final List<? extends Number> results = solution.sumInRanges(new int[]{5, 2, 6, 9}, 4, queries, 3);
        assertEquals(27, results.get(0));
        assertEquals(22, results.get(1));
        assertEquals(28, results.get(2));
    }

    @ParameterizedTest
    @MethodSource("provideSolutions")
    void testBig(Solution solution) throws Exception {

        String inputFile = "input3.txt";
        String outputFile = "output3.txt";
        final List<List<Integer>> expectedOutput = readExpectedOutput(outputFile);
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(inputFile).getFile());
        try (Scanner scanner = new Scanner(file)) {

                int numberOfTestCases = scanner.nextInt();
                for(int t = 0; t < numberOfTestCases; t++) {
                    int N = scanner.nextInt();
                    int[] arr = new int[N];
                    for(int e = 0; e < N; e++) {
                        arr[e] = scanner.nextInt();
                    }
                    final int Q = scanner.nextInt();
                    List<List<Long>> queries = new ArrayList<>(Q);
                    for(int q = 0; q < Q; q++) {
                        final long L = scanner.nextLong();
                        final long R = scanner.nextLong();
                        List<Long> query = new ArrayList<>(2);
                        query.add(L);
                        query.add(R);
                        queries.add(query);
                    }
                    final List<? extends Number> result = solution.sumInRanges(arr, N, queries, Q);
                    assertEquals(expectedOutput.get(t), result);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<List<Integer>> readExpectedOutput(String outputFile) throws Exception {

        List<List<Integer>> expectedOutput = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(outputFile).getFile());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                final String s = scanner.nextLine();
                final String[] split = s.split("\\s+");
                final List<Integer> list = Arrays.stream(split)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
                expectedOutput.add(list);
            }
        }

        return expectedOutput;
    }

    private static Stream<Solution> provideSolutions() {
        return Stream.of(
            SolutionBruteForce::sumInRanges,
            SolutionPrefixSumArray::sumInRanges
        );
    }
}
