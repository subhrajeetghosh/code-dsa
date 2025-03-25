package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections
 * 
 * @author subhrajeetghosh
 */
public class GridCutOutInSections {
    public boolean checkValidCuts(int n, int[][] rectangles) { // time complexity - O(nlogn)
        int[][] xArr = new int[rectangles.length][2];
        int[][] yArr = new int[rectangles.length][2];
        for (int i = 0; i < rectangles.length; i++) {
            xArr[i][0] = rectangles[i][0];
            xArr[i][1] = rectangles[i][2];
            yArr[i][0] = rectangles[i][1];
            yArr[i][1] = rectangles[i][3];
        }
        return isCutSectionsPossible(xArr) || isCutSectionsPossible(yArr);
    }

    private boolean isCutSectionsPossible(int[][] arr) {
        int cutSectionCount = 0;
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i][1] <= arr[i + 1][0]) {
                cutSectionCount++;
            } else {
                arr[i + 1][1] = Math.max(arr[i][1], arr[i + 1][1]);
            }
        }
        return cutSectionCount >= 2;
    }
}
