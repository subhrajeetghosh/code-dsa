package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x
 * 
 * @author subhrajeetghosh
 */
public class SpecialArrayXEle {
    public int specialArray(int[] nums) { //time complexity - O(n log n)
        Arrays.sort(nums);
        int sp_num = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] >= sp_num && nums.length - i == sp_num) {
                return sp_num;
            } else if (nums[i] >= sp_num && nums.length - i > sp_num) {
                sp_num++;
            } else {
                i++;
            }
        }
        return -1;
    }
}
