package tree;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor
 * 
 * @author subhrajeetghosh
 */

public class MaxDiffWithAncestor {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int min, int max) {
        if (root == null)
            return max - min;
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        return Math.max(dfs(root.left, min, max), dfs(root.right, min, max));
    }
}
