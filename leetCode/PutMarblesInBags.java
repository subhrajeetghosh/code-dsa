package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/put-marbles-in-bags
 * 
 * @author subhrajeetghosh
 */
public class PutMarblesInBags {
    public long putMarbles(int[] weights, int k) {
        int[] pairSum = new int[weights.length - 1];
        for (int i = 0; i < weights.length - 1; i++) {
            pairSum[i] += weights[i] + weights[i + 1];
        }
        Arrays.sort(pairSum);
        long max = 0, min = 0;
        for (int i = 0; i < k - 1; i++) {
            max += pairSum[pairSum.length - 1 - i];
            min += pairSum[i];
        }
        return max - min;
    }
}
