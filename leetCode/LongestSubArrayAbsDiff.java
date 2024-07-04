package leetCode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
 * 
 * @author subhrajeetghosh
 */

public class LongestSubArrayAbsDiff {
    // Bruteforce approch
    public int longestSubarray_2ndMethod(int[] nums, int limit) { // time complexity - O(n^2)
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentResult = 1;
            int currentMin = nums[i];
            int currentMax = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                currentMin = Math.min(nums[j], currentMin);
                currentMax = Math.max(nums[j], currentMax);
                if (Math.abs(currentMin - currentMax) <= limit) {
                    currentResult++;
                    result = Math.max(currentResult, result);
                } else {
                    break;
                }
            }
        }
        return result;
    }

    // Two heaps approch
    public int longestSubarray(int[] nums, int limit) { // time complexity - O(n log n)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int left = 0, right = 0, result = 0;

        for (; right < nums.length; right++) {
            maxHeap.add(new int[] { nums[right], right });
            minHeap.add(new int[] { nums[right], right });

            while (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                left = Math.min(maxHeap.peek()[1], minHeap.peek()[1]) + 1;

                while (maxHeap.peek()[1] < left) {
                    maxHeap.poll();
                }

                while (minHeap.peek()[1] < left) {
                    minHeap.poll();
                }
            }

            result = Math.max(right - left + 1, result);
        }
        return result;
    }
}
