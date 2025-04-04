package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/apply-operations-to-maximize-score
 * 
 * @author subhrajeetghosh
 */
public class ApplyOpsMaxScore {
    Map<Integer, Integer> primeScoresMemo = new HashMap<>();
    int mod = 1000000007;

    private int getPrimeScore(int num) { // time complexity - O(sqrt(n))
        if (primeScoresMemo.containsKey(num)) {
            return primeScoresMemo.get(num);
        }
        int score = 0;
        int tempNum = num;
        for (int i = 2; i * i <= tempNum; i++) {
            if (tempNum % i == 0) {
                score++;
                while (tempNum % i == 0) {
                    tempNum /= i;
                }
            }
        }
        if (tempNum > 1) {
            score++;
        }
        primeScoresMemo.put(num, score);
        return score;
    }

    private long power(long base, long exp) {
        long result = 1l;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

    public int maximumScore(List<Integer> nums, int k) {
        int[] primeScores = new int[nums.size()];
        // get the primescores
        for (int i = 0; i < nums.size(); i++) {
            primeScores[i] = getPrimeScore(nums.get(i));
        }

        int[] previousGreaterEqual = new int[nums.size()];
        int[] nextGreater = new int[nums.size()];
        Arrays.fill(previousGreaterEqual, -1);
        Arrays.fill(nextGreater, nums.size());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.size(); i++) {
            while (!stack.isEmpty() && primeScores[stack.peek()] < primeScores[i]) {
                nextGreater[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && primeScores[stack.peek()] <= primeScores[i]) {
                previousGreaterEqual[stack.pop()] = i;
            }
            stack.push(i);
        }
        Long[] dominant = new Long[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            dominant[i] = (long) (i - previousGreaterEqual[i]) * (nextGreater[i] - i);
        }
        long result = 1l;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new int[] { nums.get(i), i });
        }
        while (k > 0 && !pq.isEmpty()) {
            int[] currentNum = pq.poll();
            long exp = Math.min((long) k, dominant[currentNum[1]]);
            result = (result * power(currentNum[0], exp)) % mod;
            k -= exp;
        }
        return (int) result;
    }
}
