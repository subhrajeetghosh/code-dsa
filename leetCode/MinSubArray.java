package leetCode;

/**
 * sub array problem
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * 
 * @author subhrajeetghosh
 */
public class MinSubArray {
    public int minSubArrayLen(int target, int[] nums) { // time complexity - O(n)
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = Integer.MAX_VALUE;
        while (right <= nums.length && left <= right) {
            if (right < nums.length && sum < target) {
                sum += nums[right++];
            } else if (sum == target || sum > target) {
                count = Math.min(count, (right - left));
                sum -= nums[left++];
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 2, 4, 3 };
        MinSubArray obj = new MinSubArray();
        obj.minSubArrayLen(7, arr);
    }
}