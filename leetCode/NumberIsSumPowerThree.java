package leetCode;

/**
 * https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
 * 
 * @author subhrajeetghosh
 */
public class NumberIsSumPowerThree {
    public boolean checkPowersOfThree(int n) { // time complexity - O(2^ log 3(n))
        int count = 0;
        while (Math.pow(3, count) < n) {
            count++;
        }
        return isPowerOfThree(n, 0, count, 0);
    }

    private boolean isPowerOfThree(int n, int index, int limit, int currentSum) {
        if (currentSum == n) {
            return true;
        } else if (currentSum > n) {
            return false;
        }
        for (int i = index; i <= limit; i++) {
            currentSum += Math.pow(3, i);
            if (isPowerOfThree(n, i + 1, limit, currentSum)) {
                return true;
            }
            currentSum -= Math.pow(3, i);
        }
        return false;
    }

    // Optimized solution
    public boolean checkPowersOfThree_2ndMethod(int n) { // time complexity - O(log 3(n))
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
