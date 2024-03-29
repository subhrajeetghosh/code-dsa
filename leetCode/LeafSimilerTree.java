package leetCode;

import java.util.ArrayList;
import java.util.List;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/leaf-similar-trees/
 * 
 * @author subhrajeetghosh
 */
public class LeafSimilerTree {

    // dfs approch
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        if (list1.size() != list2.size())
            return false;
        return list1.equals(list2);
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
