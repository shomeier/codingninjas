// https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118820/offering/1381865
package module1.arrays.sumofinfinitearray;

import java.util.List;
import java.util.ArrayList;

public class Solution {

    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {

        List<Integer> allSums = new ArrayList<>();
        for(List<Long> query : queries) {
            long sum = 0;
            System.out.println("----------");
            for(int i = query.get(0).intValue(); i <= query.get(1).intValue(); i++) {
                sum += elementAt(arr, i-1);
                System.out.println(String.format("-> %d", sum));
            }
            allSums.add((int) sum);
            System.out.println("----------");
        }
        return allSums;
    }

    private static int elementAt(int[] arr, int index) {
        return arr[index % arr.length];
    }
}
