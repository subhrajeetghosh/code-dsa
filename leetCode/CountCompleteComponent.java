package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-the-number-of-complete-components
 * 
 * @author subhrajeetghosh
 */

public class CountCompleteComponent {
    public int countCompleteComponents(int n, int[][] edges) { // time complexity - O(n + m)
        int completeCount = 0;
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int[] info = { 0, 0 };
            dfs(i, graph, visited, info);
            if (info[0] * (info[0] - 1) == info[1]) {
                completeCount++;
            }
        }
        return completeCount;
    }

    private void dfs(int node, List<Integer>[] graph, boolean[] visited, int[] info) {
        visited[node] = true;
        info[0]++;
        info[1] += graph[node].size();
        for (int ng : graph[node]) {
            if (!visited[ng]) {
                dfs(ng, graph, visited, info);
            }
        }
    }
}
