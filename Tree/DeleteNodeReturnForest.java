package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/delete-nodes-and-return-forest
 * 
 * @author subhrajeetghosh
 */
public class DeleteNodeReturnForest {
    Set<Integer> deleteNode;
    List<TreeNode> result;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) { // time complexity - O(n)
        deleteNode = new HashSet<>();
        result = new ArrayList<>();
        for (int i : to_delete) {
            deleteNode.add(i);
        }
        dfs(root, true);
        return result;
    }

    private TreeNode dfs(TreeNode node, boolean is_root) {
        if (node == null)
            return null;
        boolean deleted = deleteNode.contains(node.val);
        if (is_root && !deleted) {
            result.add(node);
        }
        node.left = dfs(node.left, deleted);
        node.right = dfs(node.right, deleted);
        return deleted ? null : node;
    }
}
