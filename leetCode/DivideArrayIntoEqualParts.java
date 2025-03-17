package leetCode;

/**
 * https://leetcode.com/problems/divide-array-into-equal-pairs
 * 
 * @author subhrajeetghosh
 */
public class DivideArrayIntoEqualParts {
    public boolean divideArray(int[] nums) { //time complexity - O(n)
        int[] storeArr = new int[501];
        for (int i = 0; i < nums.length; i++) {
            storeArr[nums[i]]++;
        }
        for (int i = 0; i < storeArr.length; i++) {
            if (storeArr[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
