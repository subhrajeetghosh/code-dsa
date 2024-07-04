package leetCode;

import commonfile.ListNode;

/**
 * https://leetcode.com/problems/merge-nodes-in-between-zeros/
 * 
 * @author subhrajeetghosh
 */
public class MergeListBetweenZero {
    public ListNode mergeNodes(ListNode head) { // time complexity - O(n)
        ListNode result = new ListNode(0);
        ListNode resultPointer = result;
        int currentRes = 0;
        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                resultPointer.next = new ListNode(currentRes);
                resultPointer = resultPointer.next;
                currentRes = 0;
            } else {
                currentRes += head.val;
            }
            head = head.next;
        }
        return result.next;
    }
}
