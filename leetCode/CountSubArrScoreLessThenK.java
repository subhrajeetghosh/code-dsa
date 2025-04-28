package leetCode;

/**
 * https://leetcode.com/problems/count-subarrays-with-score-less-than-k
 * 
 * @author subhrajeetghosh
 */
public class CountSubArrScoreLessThenK {
    public long countSubarrays_2ndMethod(int[] nums, long k) { // time complexity - O(n)
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum * (j - i + 1) < k) {
                    result++;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public long countSubarrays(int[] nums, long k) { // time complexity - O(n)
        long result = 0, currentSum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            currentSum += nums[right++];
            while (currentSum * (right - left) >= k) {
                currentSum -= nums[left++];
            }
            result += right - left;

        }
        return result;
    }
}
