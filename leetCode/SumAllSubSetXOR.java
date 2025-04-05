package leetCode;

/**
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals
 * 
 * @author subhrajeetghosh
 */
public class SumAllSubSetXOR {
    int result = 0;

    public int subsetXORSum(int[] nums) { // time copmplexity - O(2^n) - exponential time complexity
        subSetXOR(nums, 0, 0);
        return result;
    }

    private void subSetXOR(int[] nums, int index, int currentSum) {
        result += currentSum;
        for (int i = index; i < nums.length; i++) {
            int newCurrentSum = currentSum ^ nums[i];
            subSetXOR(nums, i + 1, newCurrentSum);
        }
    }
}
