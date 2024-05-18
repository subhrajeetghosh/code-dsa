package leetCode;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/evaluate-boolean-binary-tree
 * 
 * @author subhrajeetghosh
 */
public class EvaluateBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        return root.val == 2 ? left || right : left && right;
    }
}
