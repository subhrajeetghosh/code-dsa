package leetCode;

import java.util.ArrayList;
import java.util.List;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers
 * 
 * @author subhrajeetghosh
 */
public class SumRootToLeaf {
    StringBuilder num = new StringBuilder();
    List<Integer> numList = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        int result = 0;
        for (int i : numList) {
            result += i;
        }
        return result;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        num.append(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            numList.add(Integer.parseInt(num.toString()));
        } else {
            dfs(root.left);
            dfs(root.right);
        }
        num.deleteCharAt(num.length() - 1);
    }
}
