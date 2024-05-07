package leetCode;

import commonfile.ListNode;

/**
 * https://leetcode.com/problems/remove-nodes-from-linked-list
 * 
 * @author subhrajeetghosh
 */
public class RemoveLinkedListNode {
    //Bruteforce approch
    public ListNode removeNodes_1(ListNode head) { //time complexity - o(n^2)
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            boolean isGreater = false;
            while (next != null) {
                if (curr.val < next.val) {
                    isGreater = true;
                    break;
                } else {
                    next = next.next;
                }
            }
            if (isGreater) {
                if (prev != null) {
                    prev.next = next;
                } else {
                    head = next;
                }
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public ListNode removeNodes(ListNode head) {
        if(head == null) return head;
        head.next = removeNodes(head.next);
        return head.next != null && head.val < head.next.val ? head.next : head;
    }
}
