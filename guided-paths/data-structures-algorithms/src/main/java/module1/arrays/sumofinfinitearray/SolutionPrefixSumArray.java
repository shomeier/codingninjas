// https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118820/offering/1381865
package module1.arrays.sumofinfinitearray;

import java.util.ArrayList;
import java.util.List;

public class SolutionPrefixSumArray {

    private static int mod = (int) 1e9 + 7;

    //    O(Q+N) per test case, where N is the size of the given array, and Q is the number of queries given
    //    In the worst case, we will only traverse the given array, O(N) only one time, and for each query (O(Q)),
    //    we will be calculating the sum in constant time. Thus a total of O(N+Q) time will be required.
    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {

        // prefix sum array
        final long[] psa = getPrefixSumArray(arr);

        List<Integer> allSums = new ArrayList<>();
        for(List<Long> query : queries) {
            // make L and R 0-based
            long L = query.get(0) - 1;
            long R = query.get(1) - 1;

            long sumUpToL = (L == 0) ? 0 : getElementAtInfinitePsa((int) ((L - 1) % mod), psa);
            long sumUpToR = getElementAtInfinitePsa((int) (R % mod), psa);
            allSums.add((int) ((sumUpToR - sumUpToL + mod) % mod));
        }
        return allSums;
    }

    private static long[] getPrefixSumArray(int[] arr) {

        long[] prefixSumArray = new long[arr.length];
        prefixSumArray[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            prefixSumArray[i] = (arr[i] + prefixSumArray[i-1]) % mod;
        }

        return prefixSumArray;
    }

    private static long getElementAtInfinitePsa(int index, long[] psa) {
        long multiplier = (index / psa.length) % mod;
        return ((multiplier * psa[psa.length - 1]) % mod + (psa[index % psa.length]) % mod) % mod;
    }
}
