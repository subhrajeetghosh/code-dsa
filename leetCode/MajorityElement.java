package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/majority-element/
 * 
 * @author subhrajeetghosh
 */
public class MajorityElement {
    public int majorityElement_2ndMethod(int[] nums) { // time complexity - O(n log n)
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement(int[] nums) { // time complexity - O(n)
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                num = nums[i];
            } else if (nums[i] == num) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }
}
