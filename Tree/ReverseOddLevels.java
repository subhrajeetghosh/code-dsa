package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/reverse-odd-levels-of-binary-tree
 * 
 * @author subhrajeetghosh
 */
public class ReverseOddLevels {
    // BFS
    public TreeNode reverseOddLevels(TreeNode root) { // time complexity - O(n)
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int currentLevel = 0;
        while (!qu.isEmpty()) {
            int size = qu.size();
            List<TreeNode> currentNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = qu.poll();
                currentNodes.add(currentNode);
                if (currentNode.left != null) qu.add(currentNode.left);
                if (currentNode.right != null) qu.add(currentNode.right);
            }
            if (currentLevel % 2 == 1) {
                int left = 0, right = currentNodes.size() - 1;
                while (left < right) {
                    int temp = currentNodes.get(left).val;
                    currentNodes.get(left).val = currentNodes.get(right).val;
                    currentNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            currentLevel++;
        }
        return root;
    }

    // DFS
    public TreeNode reverseOddLevels_DFS(TreeNode root) { // time complexity - O(n)
        dfs(root.left, root.right, true);
        return root;
    }

    private void dfs(TreeNode leftNode, TreeNode rightNode, boolean reversed) {
        if (leftNode == null || rightNode == null) return;
        if (reversed) {
            int temp = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = temp;
        }
        dfs(leftNode.left, rightNode.right, !reversed);
        dfs(leftNode.right, rightNode.left, !reversed);
    }
}
