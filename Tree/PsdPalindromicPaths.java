package tree;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree
 * 
 * @author subhrajeetghosh
 */
public class PsdPalindromicPaths {
    //dfs aapproch
    int result = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        preDfs(root, new int[10]);
        return result;
    }

    private void preDfs(TreeNode root, int[] arr) {
        if(root == null) return;
        arr[root.val]++;
        if(root.left == null && root.right == null) {
            if(checkPlaindrome(arr)) {
                result++;
            }
            return;
        }
        preDfs(root.left, arr);
        if(root.left != null) arr[root.left.val]--;
        preDfs(root.right, arr);
        if(root.right != null) arr[root.right.val]--;
    }

    private boolean checkPlaindrome(int[] arr) {
        boolean isOddExceed = false;
        for(int i=1; i<arr.length; i++) {
            if(arr[i] % 2 != 0 && isOddExceed) {
                return false;
            } else if(arr[i] % 2 !=0 && !isOddExceed){
                isOddExceed = true;
            }
        }
        return true;
    }
}
