// https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118820/offering/1381865
package module1.arrays.sumofinfinitearray;

import java.util.List;
import java.util.ArrayList;

public class Solution {

    private static int mod = (int) 1e9 + 7;

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
