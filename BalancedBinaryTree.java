import java.util.HashMap;
import java.util.Map;

import CommonFile.TreeNode;

/**
 * https://www.lintcode.com/problem/93/
 * Given a binary tree, determine if it is height-balanced. For this problem,
 * a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 * 
 * @author Subhrajeet Ghosh
 */
public class BalancedBinaryTree {
    Map<TreeNode, Integer> map = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        return testBalanceOfTree(root);
    }

    public boolean testBalanceOfTree(TreeNode node) {
        if (node == null)
            return true;
        if(Math.abs(height(node.left)-height(node.right))>1) return false;
        return testBalanceOfTree(node.left) && testBalanceOfTree(node.right);
    }

    public int height(TreeNode node) {
        if(node == null) return 0;
        if(map.containsKey(node)) return map.get(node);
        map.put(node, 1+Math.max(height(node.left), height(node.right)));
        return map.get(node);
    }
}
