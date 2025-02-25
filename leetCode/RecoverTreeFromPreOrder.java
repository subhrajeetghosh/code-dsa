package leetCode;

import java.util.HashMap;
import java.util.Map;

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

    public TreeNode recoverFromPreorder_2ndMethod(String str) { // time complexity - O(n)
        Map<Integer, TreeNode> map = new HashMap<>();
        int index = 0;
        while (index < str.length()) {
            int level = 0, val = 0;
            while (str.charAt(index) == '-') {
                index++;
                level++;
            }
            while (index < str.length() && Character.isDigit(str.charAt(index))) {
                val = val * 10 + (str.charAt(index++) - '0');
            }
            TreeNode node = new TreeNode(val);
            map.put(level, node);
            if (level > 0) {
                TreeNode parent = map.get(level - 1);
                if (parent.left == null)
                    parent.left = node;
                else
                    parent.right = node;
            }
        }
        return map.get(0);
    }
}
