package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/check-if-array-is-sorted-and-rotated
 * 
 * @author subhrajeetghosh
 */
public class ArrayIfSortedRotated {
    public boolean check(int[] nums) { // time complexity - O(n)
        if (nums.length < 3)
            return true;
        int[] sortedArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedArr);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sortedArr[0]) {
                if (sortedArr[0] != sortedArr[1]) {
                    index = i;
                    break;
                } else {
                    if (i > 0 && nums[i - 1] != nums[i]) {
                        index = i;
                    }
                }
            }
        }
        for (int i = 0; i < sortedArr.length; i++) {
            if (sortedArr[i] != nums[index]) {
                return false;
            } else {
                index++;
                if (index == nums.length)
                    index = 0;
            }
        }
        return true;
    }
}
