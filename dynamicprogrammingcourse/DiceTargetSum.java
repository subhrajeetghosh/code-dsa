package dynamicprogrammingcourse;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum
 * 
 * @author Subhrajeet Ghosh
 */
public class DiceTargetSum {
    int res = 0;

    // BruteForce Approch
    public int numRollsToTarget_1stMethod(int n, int k, int target) { // time complexity - O(k^n)
        int[] dice = new int[k];
        for (int i = 0; i < k; i++) {
            dice[i] = i + 1;
        }
        recOfRolls(dice, n, target);
        return res;
    }

    private void recOfRolls(int[] dice, int n, int target) {
        if (n < 0)
            return;
        if (n == 0 && target == 0) {
            res++;
            return;
        }
        for (int i = 0; i < dice.length; i++) {
            recOfRolls(dice, n - 1, target - dice[i]);
        }
    }

    //dynamic programming memorization
    public int numRollsToTarget(int n, int k, int target) { // time complexity - O(n*k)
        int[] dice = new int[k];
        for (int i = 0; i < k; i++) {
            dice[i] = i + 1;
        }
        return recOfRolls_2nd(dice, n, target);
    }

    Map<String, Integer> map = new HashMap<>();

    public int recOfRolls_2nd(int[] dice, int n, int target) {
        if (n < 0)
            return 0;
        if (n == 0 && target == 0) {
            return 1;
        }
        String currentKey = new StringBuilder().append(n + "_" + target).toString();
        if (map.containsKey(currentKey)) {
            return map.get(currentKey);
        }
        int count = 0;
        for (int i = 0; i < dice.length; i++) {
            count += recOfRolls_2nd(dice, n - 1, target - dice[i]);
            count %= 1000000007;
        }
        map.put(currentKey, count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new DiceTargetSum().numRollsToTarget(2, 6, 7));
    }
}
