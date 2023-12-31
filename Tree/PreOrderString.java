package tree;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 * 
 * @author subhrajeetghosh
 */
public class PreOrderString {
    public String tree2str(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder mainString = new StringBuilder(String.valueOf(root.val));
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        if (!left.isEmpty() && right.isEmpty()) {
            mainString.append("(").append(left).append(")");
        } else if(!left.isEmpty() || !right.isEmpty()){
            mainString.append("(").append(left).append(")");
            mainString.append("(").append(right).append(")");
        }
        return mainString.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        new PreOrderString().tree2str(root);
    }
}
