package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NumWaysMinCostArriveDest {
    Map<Integer, Integer> resultSet;
    int mod = 1000000007;

    // DFS bruteforce approch
    public int countPaths(int n, int[][] roads) { // time complexity - O(2^n)
        resultSet = new HashMap<>();
        @SuppressWarnings("unchecked")
        Map<Integer, Integer>[] graph = new HashMap[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashMap<>();
        }
        for (int[] road : roads) {
            graph[road[0]].put(road[1], road[2]);
            graph[road[1]].put(road[0], road[2]);
        }
        dfs(graph, 0, new boolean[n], n, 0);
        int minPath = Integer.MAX_VALUE, resultCount = 0;
        for (int key : resultSet.keySet()) {
            if (minPath > key) {
                resultCount = resultSet.get(key);
                minPath = key;
            }
        }
        return resultCount;
    }

    private void dfs(Map<Integer, Integer>[] graph, int index, boolean[] visited, int n, int currentPath) {
        if (index == n - 1) {
            resultSet.put(currentPath, resultSet.getOrDefault(currentPath, 0) + 1);
            return;
        }
        if (visited[index])
            return;
        visited[index] = true;
        for (int key : graph[index].keySet()) {
            int newCurrentPath = currentPath + graph[index].get(key) % mod;
            dfs(graph, key, visited, n, newCurrentPath);
        }
        visited[index] = false;
    }

    public int countPaths_2ndMethod(int n, int[][] roads) { // time complexity - O((n + m)log n)
        int mod = 1000000007;
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            graph[road[0]].add(new int[] { road[1], road[2] });
            graph[road[1]].add(new int[] { road[0], road[2] });
        }
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[] { 0, 0 });
        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            int node = (int) current[0];
            long currentDist = current[1];
            if (dist[node] < currentDist)
                continue;
            for (int[] neighbor : graph[node]) {
                int next = neighbor[0];
                long nextDist = neighbor[1] + currentDist;
                if (dist[next] > nextDist) {
                    dist[next] = nextDist;
                    ways[next] = ways[node];
                    pq.add(new long[] { next, nextDist });
                } else if (dist[next] == nextDist) {
                    ways[next] = (ways[next] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}
