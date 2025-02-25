package leetCode;

/**
 * https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum
 * 
 * @author subhrajeetghosh
 */
public class NumberSubArrayWithOddSum {
    public int numOfSubarrays(int[] arr) { // time complexity - O(n^2)
        int MOD = 1000000007;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum % 2 == 1) {
                    result = (result + 1) % MOD;
                }
            }
        }
        return result;
    }

    public int numOfSubarrays_2ndMethod(int[] arr) { // time copmlexity - O(n)
        int result = 0, currentSum = 0, mod = 1000000007, evenCount = 1, oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum % 2 == 1) {
                result = (result + evenCount) % mod;
                oddCount++;
            } else {
                result = (result + oddCount) % mod;
                evenCount++;
            }
        }
        return result;
    }
}
