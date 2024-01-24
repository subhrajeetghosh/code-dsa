package tree;

import java.util.HashSet;
import java.util.Set;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree
 * 
 * @author subhrajeetghosh
 */
public class PsdPalindromicPaths {
    // dfs aapproch
    int result = 0;

    public int pseudoPalindromicPaths(TreeNode root) { // time complexity - O(n)
        preDfs(root, new int[10]);
        return result;
    }

    private void preDfs(TreeNode root, int[] arr) {
        if (root == null)
            return;
        arr[root.val]++;
        if (root.left == null && root.right == null) {
            if (checkPlaindrome(arr)) {
                result++;
            }
            return;
        }
        preDfs(root.left, arr);
        if (root.left != null)
            arr[root.left.val]--;
        preDfs(root.right, arr);
        if (root.right != null)
            arr[root.right.val]--;
    }

    private boolean checkPlaindrome(int[] arr) {
        boolean isOddExceed = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && isOddExceed) {
                return false;
            } else if (arr[i] % 2 != 0 && !isOddExceed) {
                isOddExceed = true;
            }
        }
        return true;
    }

    // another dfs approch
    public int pseudoPalindromicPaths_2ndMethod(TreeNode root) { // time complexity - O(n)
        return dfs(root, new HashSet<Integer>());
    }

    private int dfs(TreeNode root, Set<Integer> set) {
        if (root == null)
            return 0;
        if (set.contains(root.val)) {
            set.remove(root.val);
        } else {
            set.add(root.val);
        }
        if (root.left == null && root.right == null) {
            return set.size() <= 1 ? 1 : 0;
        }
        int left = dfs(root.left, new HashSet<Integer>(set));
        int right = dfs(root.right, new HashSet<Integer>(set));
        return left + right;
    }
}
