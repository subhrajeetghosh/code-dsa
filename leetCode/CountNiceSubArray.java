package leetCode;

/**
 * https://leetcode.com/problems/count-number-of-nice-subarrays
 * 
 * @author subhrajeetghosh
 */
public class CountNiceSubArray {
    public int numberOfSubarrays_2ndMethod(int[] nums, int k) { // time complexity - O(n^2)
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int oddCount = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 1) {
                    oddCount++;
                }
                if (oddCount == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) { // time complexity - O(n)
        int oddCount = 0, left = 0, middle = 0, right = 0, result = 0;
        while (right < nums.length) {
            if (nums[right++] % 2 == 1) {
                oddCount++;
            }

            while (oddCount > k) {
                if (nums[left] % 2 == 1)
                    oddCount--;
                left++;
                middle = left;
            }

            if (oddCount == k) {
                while (nums[middle] % 2 == 0) {
                    middle++;
                }
                result += middle - left + 1;
            }
        }
        return result;
    }
}
