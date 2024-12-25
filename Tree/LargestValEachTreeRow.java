package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row
 * 
 * @author subhtajeetghosh
 */
public class LargestValEachTreeRow {
    public List<Integer> largestValues(TreeNode root) { //time complexity - O(n)
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currentMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                currentMax = Math.max(currentMax, currentNode.val);
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
            list.add(currentMax);
        }
        return list;
    }
}
