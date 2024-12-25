package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/
 * 
 * @author subhrajeetghosh
 */
public class MinNumberOpSortBinaryTree {
    public int minimumOperations(TreeNode root) { // time complexity - O(n (k log k + k^2))
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] arr = new int[size];
            int[] sortedArr = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                arr[i] = currentNode.val;
                sortedArr[i] = currentNode.val;
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
            Arrays.sort(sortedArr);
            for (int i = 0; i < size; i++) {
                if (sortedArr[i] != arr[i]) {
                    swap(arr, i, sortedArr[i]);
                    result++;
                }
            }
        }
        return result;
    }

    private void swap(int[] arr, int currentIndex, int target) {
        for (int i = currentIndex + 1; i < arr.length; i++) {
            if (arr[i] == target) {
                arr[i] = arr[currentIndex];
                arr[currentIndex] = target;
                break;
            }
        }
    }
}
