package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/maximum-number-of-points-from-grid-queries
 * 
 * @author subhrajeetghosh
 */
public class MaxNumPointsGridQueries {
    public int[] maxPoints(int[][] grid, int[] queries) { //time complexity - O(m*n * log(m*n))
        TreeMap<Integer, List<Integer>> queryMap = new TreeMap<>();
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queryMap.containsKey(queries[i])) {
                queryMap.get(queries[i]).add(i);
            } else {
                queryMap.put(queries[i], new ArrayList<>());
                queryMap.get(queries[i]).add(i);
            }
        }
        int[][] dirs = { { 0, 1 }, { -1, 0 }, { 1, 0 }, { 0, -1 } };
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        minHeap.offer(new int[] { grid[0][0], 0, 0 });
        for (int queryValue : queryMap.keySet()) {
            while (!minHeap.isEmpty() && minHeap.peek()[0] < queryValue) {
                int[] cell = minHeap.poll();
                count++;
                for (int[] dir : dirs) {
                    int newRow = dir[0] + cell[1];
                    int newCol = dir[1] + cell[2];
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                            && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        minHeap.offer(new int[] { grid[newRow][newCol], newRow, newCol });
                    }
                }
            }
            for (int index : queryMap.get(queryValue)) {
                result[index] = count;
            }
        }
        return result;
    }
}
