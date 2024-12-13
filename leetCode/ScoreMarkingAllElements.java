package leetCode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements
 * 
 * @author subhrajeetghosh
 */
public class ScoreMarkingAllElements {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> { // time complexity - O(n log n)
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] { nums[i], i });
        }
        int marked = 0;
        long result = 0;
        while (marked != nums.length) {
            int[] currentArr = pq.peek();
            if (!visited[currentArr[1]]) {
                result += currentArr[0];
                marked++;
                visited[currentArr[1]] = true;
                int left = currentArr[1] - 1;
                int right = currentArr[1] + 1;
                if (left >= 0 && !visited[left]) {
                    marked++;
                    visited[left] = true;
                }
                if (right < nums.length && !visited[right]) {
                    marked++;
                    visited[right] = true;
                }
            }
            pq.poll();
        }
        return result;
    }
}
