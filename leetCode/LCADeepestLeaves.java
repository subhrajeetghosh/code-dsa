package tree;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves
 * 
 * @author subhrajeetghosh
 */
public class LCADeepestLeaves {
    private int height(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) { // time complexity - O(n^2)
        if (root == null)
            return null;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight > rightHeight) {
            return lcaDeepestLeaves(root.left);
        } else if (rightHeight > leftHeight) {
            return lcaDeepestLeaves(root.right);
        }
        return root;
    }

    int maxDepth = 0;
    TreeNode result;

    public TreeNode lcaDeepestLeaves_2ndMethod(TreeNode root) { // time complexity - O(n)
        dfs(root, 0);
        return result;
    }

    private int dfs(TreeNode node, int currentDeep) {
        maxDepth = Math.max(maxDepth, currentDeep);
        if (node == null)
            return currentDeep;
        int left = dfs(node.left, currentDeep + 1);
        int right = dfs(node.right, currentDeep + 1);
        if (left == maxDepth && right == maxDepth) {
            result = node;
        }
        return Math.max(left, right);
    }

    // another optimized approach
    public TreeNode lcaDeepestLeaves_3rdMethod(TreeNode root) { // time complexity - O(n)
        return dfs(root).lca;
    }

    private NodeInfo dfs(TreeNode node) {
        if (node == null) {
            return new NodeInfo(0, null);
        }
        NodeInfo left = dfs(node.left);
        NodeInfo right = dfs(node.right);
        if (left.height == right.height) {
            return new NodeInfo(right.height + 1, node);
        } else if (left.height > right.height) {
            return new NodeInfo(left.height + 1, left.lca);
        } else {
            return new NodeInfo(right.height + 1, right.lca);
        }
    }

    class NodeInfo {
        int height;
        TreeNode lca;

        public NodeInfo(int height, TreeNode lca) {
            this.height = height;
            this.lca = lca;
        }
    }
}
