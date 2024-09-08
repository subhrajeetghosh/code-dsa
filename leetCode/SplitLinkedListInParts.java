package leetCode;

import commonfile.ListNode;

/**
 * https://leetcode.com/problems/split-linked-list-in-parts
 * 
 * @author subhrajeetghosh
 */
public class SplitLinkedListInParts {
    public ListNode[] splitListToParts_2ndMethod(ListNode head, int k) { //time complexity = O(n)
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int minLen = 0;
        int rem = 0;
        if (k >= len) {
            minLen = 1;
        } else {
            minLen = len / k;
            rem = len % k;
        }
        ListNode[] result = new ListNode[k];
        for (int j = 0; j < k; j++) {
            ListNode currentHead = head;
            ListNode prev = head;
            for (int i = 0; i < minLen; i++) {
                if (head != null) {
                    prev = head;
                    head = head.next;
                } else {
                    break;
                }
            }
            if (rem > 0) {
                prev = head;
                head = head.next;
                rem--;
            }
            if (prev != null)
                prev.next = null;
            result[j] = currentHead;
        }
        return result;
    }

    //concise solution
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        for (ListNode curr = head; curr != null; curr = curr.next) len++;
    
        int minLen = len / k, rem = len % k;
        ListNode[] result = new ListNode[k];
    
        for (int i = 0; i < k; i++) {
            result[i] = head;
            ListNode prev = null;
    
            for (int j = 0; j < minLen + (rem > 0 ? 1 : 0); j++) {
                prev = head;
                head = head.next;
            }
            if (prev != null) prev.next = null;
            if (rem > 0) rem--;  
        }
        return result;
    }
}
