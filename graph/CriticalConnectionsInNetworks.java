package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/critical-connections-in-a-network/
 * 
 * @author subhrajeetghosh
 */
public class CriticalConnectionsInNetworks {
    int time = 0;
    List<List<Integer>> result;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) { // time complexity - O(V + E)
        result = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            adjList.get(connection.get(0)).add(connection.get(1));
            adjList.get(connection.get(1)).add(connection.get(0));
        }
        int[] currentRank = new int[n];
        int[] lowerRank = new int[n];
        Arrays.fill(currentRank, -1);
        for (int i = 0; i < n; i++) {
            dfs(i, -1, currentRank, lowerRank, adjList);
        }
        return result;
    }

    private void dfs(int node, int parent, int[] currentRank, int[] lowerRank, List<List<Integer>> adjList) {
        currentRank[node] = lowerRank[node] = time++;
        for (int ngb : adjList.get(node)) {
            if (ngb == parent)
                continue;
            if (currentRank[ngb] == -1) {
                dfs(ngb, node, currentRank, lowerRank, adjList);
                lowerRank[node] = Math.min(lowerRank[node], lowerRank[ngb]);
                if (currentRank[node] < lowerRank[ngb]) {
                    List<Integer> resultSet = new ArrayList<>(Arrays.asList(node, ngb));
                    result.add(resultSet);
                }
            } else {
                lowerRank[node] = Math.min(lowerRank[node], currentRank[ngb]);
            }
        }
    }
}
