package leetCode;

/**
 * https://leetcode.com/problems/zero-array-transformation-i
 * 
 * @author subhrajeetghosh
 */
public class ZeroArrayTransformation1 {
    public boolean isZeroArray(int[] nums, int[][] queries) { // time complexity - O(n + k)
        int[] prefixSum = new int[nums.length + 1];
        for (int[] query : queries) {
            prefixSum[query[0]]--;
            prefixSum[query[1] + 1]++;
        }
        nums[0] += prefixSum[0];
        for (int i = 1; i < prefixSum.length - 1; i++) {
            prefixSum[i] += prefixSum[i - 1];
            nums[i] = Math.max(0, nums[i] + prefixSum[i]);
        }
        for (int num : nums) {
            if (num > 0)
                return false;
        }
        return true;
    }

    // Bruteforce Approch
    public boolean isZeroArray_2ndMethod(int[] nums, int[][] queries) { // time complexity - O(n + mk)
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[1]; i++) {
                if (nums[i] > 0) {
                    nums[i]--;
                }
            }
        }
        for (int num : nums) {
            if (num > 0)
                return false;
        }
        return true;
    }
}
