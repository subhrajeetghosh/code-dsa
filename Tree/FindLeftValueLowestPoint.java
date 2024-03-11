package tree;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value
 * 
 * @author subhrajeetghosh
 */
public class FindLeftValueLowestPoint {
    int currentLeft = 0;
    int currentLen = 0;

    public int findBottomLeftValue(TreeNode root) { // time complexity - O(n)
        if (root == null)
            return 0;
        currentLeft = root.val;
        dfs(root, 0);
        return currentLeft;
    }

    private void dfs(TreeNode root, int len) {
        if (root == null)
            return;
        if (currentLen < len) {
            currentLen = len;
            currentLeft = root.val;
        }
        dfs(root.left, len + 1);
        dfs(root.right, len + 1);
    }
}
