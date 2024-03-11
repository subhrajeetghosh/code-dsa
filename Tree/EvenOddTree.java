package tree;

import java.util.LinkedList;
import java.util.Queue;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/even-odd-tree/
 * 
 * @author subhrajeetghosh
 */
public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) { // time complexity - O(n)
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int currentLevel = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentLevel % 2 == 0) {
                int currentVal = Integer.MAX_VALUE;
                while (size-- > 0) {
                    TreeNode currentNode = queue.poll();
                    if (currentNode.val % 2 != 0 || currentVal <= currentNode.val) {
                        return false;
                    }
                    currentVal = currentNode.val;
                    checkLeftRight(currentNode, queue);
                }
            } else {
                int currentVal = Integer.MIN_VALUE;
                while (size-- > 0) {
                    TreeNode currentNode = queue.poll();
                    if (currentNode.val % 2 == 0 || currentVal >= currentNode.val) {
                        return false;
                    }
                    currentVal = currentNode.val;
                    checkLeftRight(currentNode, queue);
                }
            }
            currentLevel++;
        }
        return true;
    }

    private void checkLeftRight(TreeNode root, Queue<TreeNode> queue) {
        if (root.left != null) {
            queue.add(root.left);
        }
        if (root.right != null) {
            queue.add(root.right);
        }
    }
}
