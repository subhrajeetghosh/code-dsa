package leetCode;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree
 * 
 * @author subhrajeetghosh
 */

public class DistCoinInBinaryTree {
    private int moves;

    public int distributeCoins(TreeNode root) { //time complexity - O(n)
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        moves += Math.abs(left) + Math.abs(right);
        return (root.val - 1) + left + right;
    }

    public int distributeCoins_2ndMethod(TreeNode root) {
        int res = 0;
        if(root.left != null) {
            res += distributeCoins(root.left);
            root.val += root.left.val - 1;
            res += Math.abs(root.left.val - 1);
        }
        if(root.right != null) {
            res += distributeCoins(root.right);
            root.val += root.right.val - 1;
            res += Math.abs(root.right.val - 1);
        }
        return res;
    }
}
