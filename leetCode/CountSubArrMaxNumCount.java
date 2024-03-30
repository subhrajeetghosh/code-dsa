package leetCode;

/**
 * https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times
 * 
 * @author subhrajeetghosh
 */
public class CountSubArrMaxNumCount {
    public long countSubarrays(int[] nums, int k) { // time complexity - O(n)
        int maxNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxNum = Math.max(nums[i], maxNum);
        }
        int numCount = 0;
        int i = 0, j = 0;
        long result = 0;
        while (i < nums.length) {
            if (nums[i] == maxNum)
                numCount++;
            while (numCount == k) {
                result += nums.length - i;
                if (nums[j] == maxNum)
                    numCount--;
                j++;
            }
            i++;
        }
        return result;
    }
}
