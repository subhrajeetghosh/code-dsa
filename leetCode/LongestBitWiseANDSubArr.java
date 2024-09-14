package leetCode;

/**
 * https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and
 * 
 * @author subhrajeetghosh
 */
public class LongestBitWiseANDSubArr {

    // bruteforce
    public int longestSubarray_2ndMethod(int[] nums) { // time complexity - O(n^2)
        int maxAnd = 0;
        int resultLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            for (int j = i; j < nums.length; j++) {
                currentNum = currentNum & nums[j];
                if (currentNum == 0)
                    break;
                if (currentNum > maxAnd) {
                    maxAnd = currentNum;
                    resultLen = j - i + 1;
                } else if (currentNum == maxAnd) {
                    resultLen = Math.max(resultLen, j - i + 1);
                }
            }
        }
        return resultLen;
    }

    // optimized
    public int longestSubarray(int[] nums) { // time complexity - O(n)
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int longest = 0, currentLongest = 0;
        for (int num : nums) {
            if (num == max) {
                currentLongest++;
                longest = Math.max(longest, currentLongest);
            } else {
                currentLongest = 0;
            }
        }
        return longest;
    }
}
