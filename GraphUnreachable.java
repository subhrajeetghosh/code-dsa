import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphUnreachable {

    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n ; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        long sum = n;
        long res = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int count = bfs(i, visited, adj);
                sum -= count;
                res += sum*count; 
            }
        }
        return res;
    }

    public int bfs(int i, boolean[] visited, List<List<Integer>> adj) {
        Queue<Integer> qu = new LinkedList<Integer>();
        qu.add(i);
        int count = 1;
        while(!qu.isEmpty()) {
            int current = qu.poll();
            for(int adjNode : adj.get(current)) {
                if(!visited[adjNode]) {
                    visited[adjNode] = true;
                    qu.add(adjNode);
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] edge = {{0,2},{0,5},{2,4},{1,6},{5,4}};
        GraphUnreachable obj = new GraphUnreachable();
        obj.countPairs(7, edge);
    }
    
}




/*
 * 2316. Count Unreachable Pairs of Nodes in an Undirected Graph
 * You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1. 
 * You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.
 * Return the number of pairs of different nodes that are unreachable from each other.
 * 
 * link - https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/
 */
