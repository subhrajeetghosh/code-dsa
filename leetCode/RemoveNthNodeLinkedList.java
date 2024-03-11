package leetCode;

import commonfile.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list
 * 
 * @author subhrajeetghosh
 */
public class RemoveNthNodeLinkedList { //time complexity - O(n)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        length -= n;
        ListNode resultNode = new ListNode(0);
        resultNode.next = head;
        currentNode = resultNode;
        while (length > 0) {
            currentNode = currentNode.next;
            length--;
        }
        currentNode.next = currentNode.next.next;
        return resultNode.next;
    }
}
