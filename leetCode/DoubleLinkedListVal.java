package leetCode;

import commonfile.ListNode;

/**
 * https://leetcode.com/problems/double-a-number-represented-as-a-linked-list
 * 
 * @author subhrajeetghosh
 */
public class DoubleLinkedListVal {
    // Optimized approch
    public ListNode doubleIt(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        boolean firstOne = true;
        while (head != null) {
            int currentSum = head.val * 2;
            if (head.next != null && head.next.val > 4) {
                currentSum += 1;
            }
            if (firstOne && currentSum > 9) {
                currentNode.next = new ListNode(1);
                currentNode = currentNode.next;
            }
            firstOne = false;
            currentNode.next = new ListNode(currentSum % 10);
            currentNode = currentNode.next;
            head = head.next;
        }
        return result.next;
    }

    // Another Optimized Approch
    public ListNode doubleIt_2(ListNode head) {
        if (head.val > 4) {
            head = new ListNode(0, head);
        }
        for (ListNode node = head; node != null; node = node.next) {
            node.val = (node.val * 2) % 10;
            if (node.next != null && node.next.val > 4) {
                node.val++;
            }
        }
        return head;
    }

    // Bruteforce Approch
    public ListNode doubleIt_1(ListNode head) {
        long sum = 0;
        while (head != null) {
            sum = (sum * 10) + head.val;
            head = head.next;
        }
        sum *= 2;
        StringBuilder sb = new StringBuilder().append(sum);
        ListNode result = new ListNode(0);
        ListNode currNode = result;
        while (!sb.isEmpty()) {
            currNode.next = new ListNode((sb.charAt(0)) - '0');
            sb.deleteCharAt(0);
            currNode = currNode.next;
        }
        return result.next;
    }
}
