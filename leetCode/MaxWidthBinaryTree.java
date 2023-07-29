package leetCode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import commonfile.TreeNode;

public class MaxWidthBinaryTree {

    Map<Integer, Integer> map = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode node, int index, int depth) {
        if (node == null) {
            return 0;
        }
        map.putIfAbsent(depth, index);
        return Math.max(index - map.get(depth) + 1,
                Math.max(dfs(node.left, index * 2, depth + 1), dfs(node.right, index * 2 + 1, depth + 1)));
    }

    // Implement in BFS
    public int widthOfBinaryTreeBfs(TreeNode root) {
        if(root==null) {
            return 0;
        }
        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        int maxWidth = 1;
        node.add(root);
        index.add(1);
        while (!node.isEmpty()) {
            int queueLength = node.size();
            int leftIndex = 0; 
            int rightIndex = 0;
            for (int i = 0; i < queueLength; i++) {
                TreeNode currentNode = node.poll();
                int currentIndex = index.poll();
                if (currentNode.left != null) {
                    node.add(currentNode.left);
                    index.add(currentIndex * 2);
                }
                if (currentNode.right != null) {
                    node.add(currentNode.right);
                    index.add(currentIndex * 2 + 1);
                }
                if (i == 0) {
                    leftIndex = currentIndex;
                }
                if (i == queueLength - 1) {
                    rightIndex = currentIndex;
                }
            }
            maxWidth = Math.max(maxWidth, rightIndex-leftIndex+1);
        }
        return maxWidth;
    }
}

/*
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 */