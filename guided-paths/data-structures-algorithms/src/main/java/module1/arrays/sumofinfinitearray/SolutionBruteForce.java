// https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118820/offering/1381865
package module1.arrays.sumofinfinitearray;

import java.util.List;
import java.util.ArrayList;

public class SolutionBruteForce {

    private static int mod = (int) 1e9 + 7;

    // O(Q*(R-L)) per test case, where Q is the number of given queries, and L and R are the given two indexes in each query.
    // In the worst case, for each query O(Q), we will be running a loop from L to R that takes (O(R-L)) time.
    // Thus a total of O(Q*(R-L)) time will be required.
    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {

        List<Integer> allSums = new ArrayList<>();
        for(List<Long> query : queries) {
            long sum = 0;
            // make L and R 0-based
            long L = query.get(0) - 1;
            long R = query.get(1) - 1;
            for(long i = L; i <= R; i++) {
                int index = (int) (i % arr.length);
                sum = (sum + arr[index]) % mod;
            }
            allSums.add((int)(sum));
        }
        return allSums;
    }
}
