package leetCode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii
 * 
 * @author subhrajeetghosh
 */
public class MinOpsToExceedThreshold {
    public int minOperations(int[] nums, int k) { //time complexity - O(n log n)
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add((long) nums[i]);
        }
        int result = 0;
        while (pq.size() >= 2 && pq.peek() < k) {
            result++;
            long first = pq.poll();
            long second = pq.poll();
            pq.add((first * 2) + second);
        }
        return result;
    }
}
