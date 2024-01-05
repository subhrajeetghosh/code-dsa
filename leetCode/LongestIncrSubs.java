package leetCode;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence
 * 
 * @author subhrajeetghosh
 */
public class LongestIncrSubs {

    // Bruteforce approch Memorized approch
    public int lengthOfLIS_2ndmethod(int[] nums) { // time complexity - O(n^2)
        if (nums.length == 0)
            return 0;
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, longestSubSeq(nums, i));
        }
        return maxLength;
    }

    public int longestSubSeq(int[] nums, int currentIndex) {
        int max = 1;
        for (int i = currentIndex + 1; i < nums.length; i++) {
            if (nums[i] > nums[currentIndex]) {
                int currMax = 1 + longestSubSeq(nums, i);
                max = Math.max(currMax, max);
            }
        }
        return max;
    }

    //dp approch
    public int lengthOfLIS(int[] nums) { // time complexity - O(n^2)
        int result = 0;
        int[] store = new int[nums.length];
        store[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (num > nums[j]) {
                    max = Math.max(max, store[j]);
                }
            }
            store[i] = 1 + max;
            result = Math.max(result, store[i]);
        }
        return result;
    }
}
