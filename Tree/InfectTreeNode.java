package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
 * 
 * @author subhrajeetghosh
 */
public class InfectTreeNode {
    Map<Integer, List<Integer>> graph;

    //BFS approch
    public int amountOfTime(TreeNode root, int start) {
        graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        buildGraph(root);
        queue.add(start);
        int minutes = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int currentNode = queue.poll();
                for (Integer node : graph.get(currentNode)) {
                    if (visited.add(node)) {
                        queue.add(node);
                    }
                }
            }
            minutes++;
        }
        return minutes;
    }

    private void buildGraph(TreeNode root) {
        if (root == null)
            return;
        graph.putIfAbsent(root.val, new ArrayList<>());
        if (root.left != null) {
            graph.putIfAbsent(root.left.val, new ArrayList<>());
            graph.get(root.left.val).add(root.val);
            graph.get(root.val).add(root.left.val);
        }
        if (root.right != null) {
            graph.putIfAbsent(root.right.val, new ArrayList<>());
            graph.get(root.right.val).add(root.val);
            graph.get(root.val).add(root.right.val);
        }
        buildGraph(root.left);
        buildGraph(root.right);
    }
}
