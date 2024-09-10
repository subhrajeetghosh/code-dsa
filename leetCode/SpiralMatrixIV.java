package leetCode;

import java.util.Arrays;

import commonfile.ListNode;

/**
 * @author subhrajeetghosh
 */
public class SpiralMatrixIV {
    public int[][] spiralMatrix(int m, int n, ListNode head) {  //time complexity - O(m*n)
        int[][] result = new int[m][n];
        int i = 0, j = 0;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        for (int[] arr : result) {
            Arrays.fill(arr, -1);
        }

        while (head != null) {
            for (j = left; j <= right && head != null; j++) {
                result[i][j] = head.val;
                head = head.next;
            }
            top++;
            j--;
            for (i = top; i <= bottom && head != null; i++) {
                result[i][j] = head.val;
                head = head.next;
            }
            right--;
            i--;
            for (j = right; j >= left && head != null; j--) {
                result[i][j] = head.val;
                head = head.next;
            }
            bottom--;
            j++;
            for (i = bottom; i >= top && head != null; i--) {
                result[i][j] = head.val;
                head = head.next;
            }
            left++;
            i++;
        }
        return result;
    }
}
