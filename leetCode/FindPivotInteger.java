package leetCode;

/**
 * https://leetcode.com/problems/find-the-pivot-integer
 * 
 * @author subhrajeetghosh
 */
public class FindPivotInteger {
    // Bruteforce approch
    public int pivotInteger_2ndMethod(int n) { // time complexity - O(sqrt(n))
        if (n <= 1)
            return 1;
        int i = 2, j = n - 1;
        int leftVal = 1, rightVal = n;
        while (i <= j) {
            if (leftVal < rightVal) {
                leftVal += i++;
            } else if (leftVal > rightVal) {
                rightVal += j--;
            } else if (leftVal == rightVal && i == j) {
                return i;
            }
        }
        return -1;
    }

    // Optimized Approch
    public int pivotInteger(int n) { // time complexity - O(n)
        for (int i = 1; i <= n; i++) {
            int leftSum = (i * (i + 1)) / 2;
            int rightSum = (n * (n + 1)) / 2;
            if (leftSum == rightSum - leftSum + i) {
                return i;
            }
        }
        return -1;
    }
}
