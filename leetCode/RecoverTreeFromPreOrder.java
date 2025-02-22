package leetCode;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/recover-a-tree-from-preorder-traversal
 * 
 * @author subhrajeet ghosh
 */
public class RecoverTreeFromPreOrder {
    int index = 0;

    public TreeNode recoverFromPreorder(String traversal) { // time complexity - O(n)
        return dfs(traversal, 0);
    }

    private TreeNode dfs(String str, int depth) {
        if (index >= str.length())
            return null;
        int dashes = 0;
        while (str.charAt(index + dashes) == '-') {
            dashes++;
        }
        if (dashes != depth)
            return null;

        int num = 0;
        index += dashes;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            num = num * 10 + (str.charAt(index++) - '0');
        }
        TreeNode root = new TreeNode(num);
        root.left = dfs(str, depth + 1);
        root.right = dfs(str, depth + 1);
        return root;
    }
}
