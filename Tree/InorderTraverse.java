package tree;

import java.util.ArrayList;
import java.util.List;

import commonfile.TreeNode;

public class InorderTraverse {
    List<Integer> inorderList = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return inorderList;
    }
    private void dfs(TreeNode root) {
        if(root==null) return;
        dfs(root.left);
        inorderList.add(root.val);
        dfs(root.right);
    }
}
