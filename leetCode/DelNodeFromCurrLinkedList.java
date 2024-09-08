package leetCode;

import java.util.HashSet;
import java.util.Set;

import commonfile.ListNode;

/**
 * https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array
 * 
 * @author subhrajeetghosh
 */
public class DelNodeFromCurrLinkedList {
    public ListNode modifiedList(int[] nums, ListNode head) { //time complexity - O(n + m)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode newHead = result;
        while (newHead.next != null) {
            if (set.contains(newHead.next.val)) {
                newHead.next = newHead.next.next;
            } else {
                newHead = newHead.next;
            }
        }
        return result.next;
    }
}
