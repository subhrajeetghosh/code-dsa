package leetCode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/furthest-building-you-can-reach
 * 
 * @author subhrajeetghosh
 */
public class FurthestBuildingReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) { // time complexity - O(n log n)
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] - heights[i - 1] > 0) {
                pq.add(heights[i] - heights[i - 1]);
            }
            if (pq.size() > ladders) {
                bricks -= pq.poll();
            }
            if (bricks < 0) {
                return i - 1;
            }
        }
        return heights.length - 1;
    }
}
