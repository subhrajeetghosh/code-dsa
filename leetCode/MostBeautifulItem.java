package leetCode;

import java.util.Arrays;
import java.util.TreeMap;

public class MostBeautifulItem {
    public int[] maximumBeauty(int[][] items, int[] queries) { //time complexity - O (n log n)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int max = -1;
        for (int[] item : items) {
            max = Math.max(max, item[1]);
            map.put(item[0], max);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (map.floorEntry(queries[i]) != null) {
                ans[i] = map.floorEntry(queries[i]).getValue();
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }
}
