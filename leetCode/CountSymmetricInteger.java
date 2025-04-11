package leetCode;

/**
 * https://leetcode.com/problems/count-symmetric-integers
 * 
 * @author subhrajeetghosh
 */
public class CountSymmetricInteger {
    public int countSymmetricIntegers(int low, int high) { // time complexity - O(n * d)
        int result = 0;
        for (int i = low; i <= high; i++) {
            String currentVal = String.valueOf(i);
            if (currentVal.length() % 2 == 0) {
                if (isValidDigit(currentVal)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isValidDigit(String digit) {
        int left = 0, right = digit.length() - 1, leftSum = 0, rightSum = 0;
        while (left < right) {
            leftSum += digit.charAt(left++) - '0';
            rightSum += digit.charAt(right--) - '0';
        }
        return leftSum == rightSum;
    }
}
