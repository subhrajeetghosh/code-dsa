package leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 
 * @author subhrajeetghosh
 */
public class MinArrowsToBurst {
    public int findMinArrowShots(int[][] points) { // time complexity - O(n log n)
        Arrays.sort(points, Comparator.comparing((int[] a) -> a[1]));
        long currentHigh = Long.MIN_VALUE;
        int burstCount = 0;
        for (int[] arr : points) {
            if (currentHigh < arr[0]) {
                burstCount++;
                currentHigh = arr[1];
            }
        }
        return burstCount;
    }
}
