package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-closest-node-to-given-two-nodes
 * 
 * @author subhrajeetghosh
 */
public class ClosestNodeOfTwoNodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) { // time complexity - O(n)
        int[] node1Dist = new int[edges.length];
        int[] node2Dist = new int[edges.length];
        Set<Integer> visited = new HashSet<>();
        Arrays.fill(node1Dist, -1);
        Arrays.fill(node2Dist, -1);
        dfs(edges, node1, 0, node1Dist, visited);
        visited.clear();
        dfs(edges, node2, 0, node2Dist, visited);
        int result = -1, minDist = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            if (node1Dist[i] != -1 && node2Dist[i] != -1) {
                int currentMinDist = Math.max(node1Dist[i], node2Dist[i]);
                if (currentMinDist < minDist) {
                    minDist = currentMinDist;
                    result = i;
                }
            }
        }
        return result;
    }

    private void dfs(int[] edges, int currentNode, int currentDist, int[] distArr, Set<Integer> visited) {
        visited.add(currentNode);
        distArr[currentNode] = currentDist;
        if (edges[currentNode] != -1 && !visited.contains(edges[currentNode])) {
            dfs(edges, edges[currentNode], currentDist + 1, distArr, visited);
        }
    }

    public int closestMeetingNode_2ndMethod(int[] edges, int node1, int node2) { // time complexity - O(n)
        int[] dist1 = new int[edges.length];
        int[] dist2 = new int[edges.length];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        bfs(edges, node1, dist1);
        bfs(edges, node2, dist2);
        int result = -1, minDist = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int currentMinDist = Math.max(dist1[i], dist2[i]);
                if (currentMinDist < minDist) {
                    minDist = currentMinDist;
                    result = i;
                }
            }
        }
        return result;
    }

    private void bfs(int[] edges, int node, int[] dist) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        int currentDist = 0;
        boolean[] visited = new boolean[edges.length];
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            dist[currentNode] = currentDist++;
            visited[currentNode] = true;
            int nextNode = edges[currentNode];
            if (nextNode != -1 && !visited[nextNode]) {
                queue.add(nextNode);
            }
        }
    }
}
