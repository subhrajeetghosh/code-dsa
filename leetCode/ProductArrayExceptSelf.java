package leetCode;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * @author subhtajeetghosh
 */
public class ProductArrayExceptSelf {

    //optimized approch
    public int[] productExceptSelf(int[] nums) { //time complexity - O(n)
        long multipySum = 1;
        int zeroCount = 0;
        long exceptZeroMp = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                exceptZeroMp *= nums[i];
            }
            multipySum *= nums[i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && zeroCount == 1) {
                result[i] = (int) exceptZeroMp;
            } else if (nums[i] == 0 && zeroCount > 1) {
                result[i] = 0;
            } else {
                result[i] = (int) multipySum / nums[i];
            }
        }
        return result;
    }

    //another approch
    public int[] productExceptSelf_2ndMethod(int[] nums) {
        int product = 1;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = product;
            product = product * nums[i];
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * product;
            product = product * nums[i];
        }
        return ans;
    }

}
