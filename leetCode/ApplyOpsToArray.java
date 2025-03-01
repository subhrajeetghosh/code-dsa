package leetCode;

/**
 * https://leetcode.com/problems/apply-operations-to-an-array
 * 
 * @author subhrajeetghosh
 */
public class ApplyOpsToArray {
    public int[] applyOperations(int[] nums) { // time complexity - O(n)
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1] && nums[i] != 0) {
                result[index++] = nums[i] * 2;
                i++;
            } else if (nums[i] != 0) {
                result[index++] = nums[i];
            }
        }
        return result;
    }
}
