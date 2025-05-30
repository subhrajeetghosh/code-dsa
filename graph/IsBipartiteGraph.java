package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/is-graph-bipartite
 * 
 * @author subhrajeetghosh
 */
public class IsBipartiteGraph {
    public boolean isBipartite(int[][] graph) { // time complexity - O(V + E)
        int[] colour = new int[graph.length];
        Arrays.fill(colour, -1);
        for (int i = 0; i < graph.length; i++) {
            if (colour[i] == -1) {
                if (!bfs(graph, i, colour)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, int node, int[] colour) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        colour[node] = 0;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int ngb : graph[currentNode]) {
                if (colour[ngb] != -1) {
                    if (colour[ngb] == colour[currentNode]) {
                        return false;
                    }
                } else {
                    colour[ngb] = 1 - colour[currentNode];
                    queue.add(ngb);
                }
            }
        }
        return true;
    }

    public boolean isBipartite_2ndMethod(int[][] graph) { // time complexity - O(V + E)
        int[] colour = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colour[i] != 0)
                continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            colour[i] = 1;
            while (!queue.isEmpty()) {
                int currentNode = queue.poll();
                for (int ngb : graph[currentNode]) {
                    if (colour[ngb] == 0) {
                        colour[ngb] = -colour[currentNode];
                        queue.offer(ngb);
                    } else if (colour[currentNode] == colour[ngb]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // dfs approch
    public boolean isBipartite_3rdMethod(int[][] graph) { // time complexity - O(V + E)
        int[] colour = new int[graph.length];
        Arrays.fill(colour, -1);
        for (int i = 0; i < graph.length; i++) {
            if (colour[i] == -1) {
                if (!dfs(graph, i, 0, colour)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int currentNode, int currentColour, int[] colour) { // time complexity - O(V + E)
        colour[currentNode] = currentColour;
        for (int ngb : graph[currentNode]) {
            if (colour[ngb] == -1) {
                if (!dfs(graph, ngb, 1 - currentColour, colour)) {
                    return false;
                }
            } else if (colour[ngb] == currentColour) {
                return false;
            }
        }
        return true;
    }

    // different colour value
    public boolean isBipartite_4thMethod(int[][] graph) {
        int[] colour = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colour[i] == 0 && !dfs_1(graph, colour, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs_1(int[][] graph, int[] colour, int currentNode, int currentColour) {
        colour[currentNode] = currentColour;
        for (int ngb : graph[currentNode]) {
            if (colour[ngb] == 0) {
                if (!dfs_1(graph, colour, ngb, -currentColour)) {
                    return false;
                }
            } else if (colour[ngb] == currentColour) {
                return false;
            }
        }
        return true;
    }
}
