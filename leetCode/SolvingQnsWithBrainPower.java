package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/solving-questions-with-brainpower
 * 
 * @author subhrajeetghosh
 */
public class SolvingQnsWithBrainPower {
    long result = 0l;
    Map<Integer, Long> memo;

    public long mostPoints(int[][] questions) { // time complexity - O(n)
        memo = new HashMap<Integer, Long>();
        return earnedPoints(questions, 0);
    }

    private long earnedPoints(int[][] questions, int index) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        if (index >= questions.length) {
            return 0;
        }
        long currentPoints = Math.max(questions[index][0] +
                earnedPoints(questions, index + questions[index][1] + 1),
                earnedPoints(questions, index + 1));
        memo.put(index, currentPoints);
        return currentPoints;
    }

    // DP solution
    public long mostPoints_2ndMethod(int[][] questions) { // time complexity - O(n)
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            long points = questions[i][0] + (i + questions[i][1] + 1 > n ? 0 : dp[i + questions[i][1] + 1]);
            long skip = dp[i + 1];
            dp[i] = Math.max(points, skip);
        }
        return dp[0];
    }
}
