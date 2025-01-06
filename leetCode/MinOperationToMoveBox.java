package leetCode;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box
 * 
 * @author subhrajeetghosh
 */
public class MinOperationToMoveBox {
    public int[] minOperations(String boxes) {// time complexity - O(n^2)
        int[] result = new int[boxes.length()];
        char[] chrArr = boxes.toCharArray();
        for (int i = 0; i < chrArr.length; i++) {
            int ans = 0;
            for (int j = 0; j < chrArr.length; j++) {
                if (chrArr[j] == '1') {
                    ans += Math.abs(i - j);
                }
            }
            result[i] = ans;
        }
        return result;
    }

    // Optimized Approch
    public int[] minOperations_2ndMethod(String boxes) { // time complexity - O(n)
        int n = boxes.length();
        int[] result = new int[n];
        int movesToLeft = 0, boxesLeftCurrent = 0, movesToRight = 0, boxesRightCurrent = 0;
        char[] chrArr = boxes.toCharArray();
        for (int i = 0; i < n; i++) {
            result[i] += movesToLeft;
            boxesLeftCurrent += chrArr[i] - '0';
            movesToLeft += boxesLeftCurrent;

            result[n - i - 1] += movesToRight;
            boxesRightCurrent += chrArr[n - i - 1] - '0';
            movesToRight += boxesRightCurrent;
        }
        return result;
    }
}
