package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximize-happiness-of-selected-children/
 * 
 * @author subhrajeetghosh
 */
public class MaxHappinessChild {
    public long maximumHappinessSum(int[] happiness, int k) { // time complexity - O(n log n)
        long currentK = k;
        Arrays.sort(happiness);
        long result = 0;
        for (int i = happiness.length - 1; i >= 0 && currentK > 0; i--) {
            result += happiness[i] - (k - currentK) >= 0 ? happiness[i] - (k - currentK) : 0;
            currentK--;
        }
        return result;
    }
}
