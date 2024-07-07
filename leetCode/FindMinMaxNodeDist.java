package leetCode;

import commonfile.ListNode;

/**
 * https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points
 * 
 * @author subhrajeetghosh
 */
public class FindMinMaxNodeDist {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int resultMin = Integer.MAX_VALUE, resultMax = -1, prevCriticalPoint = 0, minPoint = 0;
        int prevData = head.val;
        head = head.next;
        int count = 1;
        while (head.next != null) {
            if ((head.val > prevData && head.val > head.next.val) ||
                    (head.val < prevData && head.val < head.next.val)) {
                if (prevCriticalPoint == 0) {
                    minPoint = count;
                    prevCriticalPoint = count;
                } else {
                    resultMin = Math.min(resultMin, count - prevCriticalPoint);
                    resultMax = Math.max(resultMax, count - minPoint);
                    prevCriticalPoint = count;
                }
            }
            prevData = head.val;
            head = head.next;
            count++;
        }
        return new int[] { resultMin == Integer.MAX_VALUE ? -1 : resultMin, resultMax };
    }
}
