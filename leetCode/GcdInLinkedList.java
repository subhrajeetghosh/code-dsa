package leetCode;

import commonfile.ListNode;

/**
 * https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list
 * 
 * @author subhrajeetghosh
 */
public class GcdInLinkedList {
    public ListNode insertGreatestCommonDivisors_2ndMethod(ListNode head) { // time complexity - O(n)
        ListNode result = head;
        while (head.next != null) {
            int firstNumber = head.val;
            int secondNumber = head.next.val;
            int minNumber = Math.min(firstNumber, secondNumber);
            while (minNumber > 1) {
                if (firstNumber % minNumber == 0 && secondNumber % minNumber == 0) {
                    break;
                }
                minNumber--;
            }
            ListNode next = head.next;
            head.next = new ListNode(minNumber);
            head.next.next = next;
            head = head.next.next;
        }
        return result;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode result = head;
        while (head.next != null) {
            int firstNumber = head.val;
            int secondNumber = head.next.val;
            ListNode next = head.next;
            head.next = new ListNode(gcd(firstNumber, secondNumber));
            head.next.next = next;
            head = head.next.next;
        }
        return result;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
}
