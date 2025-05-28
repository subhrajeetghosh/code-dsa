package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i
 * 
 * @author subhrajeetghosh
 */
public class MaxNumTargetConnectedTreesI {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) { // time complexity - O(m^2 + n^2)
        int[] maxTg1 = maxTarget(edges1, k);
        int[] maxTg2 = maxTarget(edges2, k - 1);
        int maxTg = Integer.MIN_VALUE;
        for (int num : maxTg2) {
            maxTg = Math.max(maxTg, num);
        }
        int[] result = new int[edges1.length + 1];
        for (int i = 0; i <= edges1.length; i++) {
            result[i] = maxTg1[i] + maxTg;
        }
        return result;
    }

    private int[] maxTarget(int[][] edges, int k) {
        int n = edges.length + 1;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] maxTargetArr = new int[n];
        for (int i = 0; i < n; i++) {
            maxTargetArr[i] = dfs(i, -1, adjList, k);
        }
        return maxTargetArr;
    }

    private int dfs(int node, int parent, List<List<Integer>> adjList, int k) {
        if (k < 0) {
            return 0;
        }
        int result = 1;
        for (int child : adjList.get(node)) {
            if (child == parent)
                continue;
            result += dfs(child, node, adjList, k - 1);
        }
        return result;
    }
}
