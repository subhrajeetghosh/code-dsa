package Tree;

import commonfile.TreeNode;

public class MaxPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {  // time complexity -> O(n)
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        int sum = Math.max(left, right) + root.val;
        max = Math.max(max, root.val + left + right);
        return sum;
    }
}
