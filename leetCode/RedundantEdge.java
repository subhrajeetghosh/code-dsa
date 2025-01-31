package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/redundant-connection
 * 
 * @author subhrajeetghosh
 */
public class RedundantEdge {
    public int[] findRedundantConnection(int[][] edges) { //time complexity - O(n^2)
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new List[edges.length + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            if (hasPath(edge[0], edge[1], new HashSet<>(), graph))
                return edge;
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return new int[0];
    }

    private boolean hasPath(int source, int dest, Set<Integer> seen, List<Integer>[] graph) {
        if (source == dest)
            return true;
        seen.add(source);
        for (int next : graph[source]) {
            if (!seen.contains(next) && hasPath(next, dest, seen, graph))
                return true;
        }
        return false;
    }
}
