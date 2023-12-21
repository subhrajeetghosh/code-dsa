package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points
 * 
 * @author Subhrajeet Ghosh
 */
public class MaxWidthVerticleArea {

    public int maxWidthOfVerticalArea(int[][] points) { // time complexity - O(n)
        int ans = 0;
        int[] arr = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            arr[i] = points[i][0];
        }
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            ans = Math.max(ans, arr[i] - arr[i - 1]);
        }
        return ans;
    }
}
