package leetCode;

import commonfile.ListNode;

/**
 * https://leetcode.com/problems/merge-in-between-linked-lists
 * 
 * @author subhrajeetghosh
 */
public class MergeBetweenLinkedList {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) { // time complexity - O(n+m)
        ListNode firstNode = null;
        ListNode headNode = list1;
        for (int i = 0; i <= b; i++) {
            if (i == a - 1) {
                firstNode = list1;
            }
            list1 = list1.next;
        }
        firstNode.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = list1;
        return headNode;
    }
}
