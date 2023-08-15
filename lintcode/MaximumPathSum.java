package lintcode;

import commonfile.TreeNode;

/**
 * https://www.lintcode.com/problem/94
 * 
 * @author subhrajeetghosh
 */

public class MaximumPathSum {

    int resultMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathFinding(root);
        return resultMax;
    }

    public int maxPathFinding(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxPathFinding(root.left);
        int right = maxPathFinding(root.right);
        int currentMax = Math.max(root.val, Math.max(left + root.val, right + root.val));
        resultMax = Math.max(resultMax, Math.max(currentMax, root.val + left + right));
        return currentMax;
    }

}
