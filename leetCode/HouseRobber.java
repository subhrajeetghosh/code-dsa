package leetCode;

/**
 * https://leetcode.com/problems/house-robber/
 * 
 * @author subhrajeetghosh
 */
public class HouseRobber {
    // bruteforce approch top-down
    public int rob_2ndMethod(int[] nums) { // time complexity - O(2^n)
        return topDown(nums, nums.length - 1);
    }

    private int topDown(int[] nums, int index) {
        if (index < 0)
            return 0;
        return Math.max(topDown(nums, index - 1), topDown(nums, index - 2) + nums[index]);
    }

    // memorized approch top down
    Integer[] memo;

    public int rob_3rdMethod(int[] nums) { // time complexity - O(n)
        memo = new Integer[nums.length];
        return topDown_2ndMethod(nums, nums.length - 1);
    }

    private int topDown_2ndMethod(int[] nums, int index) {
        if (index < 0)
            return 0;
        if (memo[index] != null) {
            return memo[index];
        }
        memo[index] = Math.max(topDown_2ndMethod(nums, index - 1), topDown_2ndMethod(nums, index - 2) + nums[index]);
        return memo[index];
    }

    // dynamic programming approch
    public int rob(int[] nums) { // time complexity - O(n)
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] sumArray = new int[nums.length];
        sumArray[0] = nums[0];
        sumArray[1] = nums[1];
        sumArray[2] = nums[0] + nums[2];
        for (int i = 3; i < nums.length; i++) {
            sumArray[i] = Math.max(sumArray[i - 2], sumArray[i - 3]) + nums[i];
        }
        return Math.max(sumArray[nums.length - 2], sumArray[nums.length - 1]);
    }
}
