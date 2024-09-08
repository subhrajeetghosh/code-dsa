package leetCode;

import java.util.LinkedList;
import java.util.Queue;

import commonfile.ListNode;
import commonfile.TreeNode;

/**
 * https://leetcode.com/problems/linked-list-in-binary-tree
 * 
 * @author subhrajeetghosh
 */
public class LinkedListInBinaryTree {
    boolean result = false;

    public boolean isSubPath_2ndMethod(ListNode head, TreeNode root) { // time complexity - O(m + n)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (result)
                return true;
            TreeNode currentNode = queue.poll();
            isTrue(head, currentNode);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return result;
    }

    public void isTrue(ListNode head, TreeNode root) {
        if (root == null)
            return;
        if (head.val == root.val && head.next == null) {
            result = true;
            return;
        } else if (head.val == root.val) {
            head = head.next;
        } else {
            return;
        }
        isTrue(head, root.left);
        isTrue(head, root.right);
    }

    // little optimze
    public boolean isSubPath(ListNode head, TreeNode root) { //time complexity - O(N * min(L,H))
        if (head == null)
            return true;
        if (root == null)
            return false;
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        return head.val == root.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }
}
