package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k
 * 
 * @author subhrajeetghosh
 */

public class SortestSubArrAtleastKSum {
    // Bruteforce Approch
    public int shortestSubarray_BF(int[] nums, int k) { // time complexity - O(n^2)
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= k) {
                    result = Math.min(result, j - i + 1);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int shortestSubarray(int[] nums, int k) { // time complexity - O(n)
        long[] prefixSum = new long[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] += prefixSum[i - 1] + nums[i - 1];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < prefixSum.length; i++) {
            while (!dq.isEmpty() && prefixSum[i] - prefixSum[dq.peekFirst()] >= k) {
                result = Math.min(result, i - dq.pollFirst());
            }

            while (!dq.isEmpty() && prefixSum[i] <= prefixSum[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.add(i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

}