package leetCode;

/**
 * https://leetcode.com/problems/best-sightseeing-pair
 * 
 * @author subhrajeetghosh
 */
public class BestSightSeeingPair {
    // BruteForce
    public int maxScoreSightseeingPair_BruteForce(int[] values) { // time complexity - O(n^2)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                max = Math.max(values[i] + values[j] + i - j, max);
            }
        }
        return max;
    }

    // optimization
    public int maxScoreSightseeingPair(int[] values) { // time complexity - O(n)
        int[] iArr = new int[values.length];
        int[] jArr = new int[values.length];
        int maxI = Integer.MIN_VALUE, maxJ = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            maxI = Math.max(maxI, values[i] + i);
            iArr[i] = maxI;
            maxJ = Math.max(maxJ, values[values.length - i - 1] - (values.length - i - 1));
            System.out.println(maxJ);
            jArr[values.length - i - 1] = maxJ;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < values.length - 1; i++) {
            result = Math.max(result, iArr[i] + jArr[i + 1]);
        }
        return result;
    }

    public int maxScoreSightseeingPair_optimize(int[] values) { // time complexity - O(n)
        int result = Integer.MIN_VALUE;
        int maxI = values[0];
        for (int i = 1; i < values.length; i++) {
            result = Math.max(result, maxI + values[i] - i);
            maxI = Math.max(maxI, values[i] + i);
        }
        return result;
    }

}
