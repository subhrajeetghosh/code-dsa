package leetCode;

/**
 * https://leetcode.com/problems/special-array-i
 * 
 * @author subhrajeetghosh
 */
public class SpecialArray1 {
    public boolean isArraySpecial(int[] nums) { // time complexity - O(n)
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] % 2 == nums[i + 1] % 2) {
                return false;
            }
        }
        return true;
    }
}
