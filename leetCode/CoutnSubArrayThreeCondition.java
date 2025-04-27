package leetCode;

/**
 * https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition
 * 
 * @author subhrajeetghosh
 */
public class CoutnSubArrayThreeCondition {
    public int countSubarrays(int[] nums) { // time complexity - O(n)
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (2 * (nums[i] + nums[i + 2]) == nums[i + 1]) {
                result++;
            }
        }
        return result;
    }
}
