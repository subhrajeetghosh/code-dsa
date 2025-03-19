package leetCode;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i
 * 
 * @author subhajeetghosh
 */
public class MinOpsBinArrayFlippingToOne {
    public int minOperations(int[] nums) { // time complexity - O(n)
        boolean isChangePossible = true;
        int index = 0, result = 0;
        while (isChangePossible) {
            isChangePossible = false;
            while (index < nums.length && nums[index] == 1) {
                index++;
            }
            if (index + 2 < nums.length) {
                result++;
                for (int i = index; i < index + 3; i++) {
                    nums[i] = nums[i] == 0 ? 1 : 0;
                }
                isChangePossible = true;
            }
        }
        return index == nums.length ? result : -1;
    }
}
