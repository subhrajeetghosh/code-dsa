package leetCode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/take-gifts-from-the-richest-pile
 * 
 * @author subhrajeetghosh
 */
public class GiftFromRichestPile {
    public long pickGifts(int[] gifts, int k) { // time complexity - O(n log n + k log n)
        PriorityQueue<Long> pq = new PriorityQueue<Long>((a, b) -> Long.compare(b, a));
        for (int giftVal : gifts) {
            pq.offer((long) giftVal);
        }
        while (k-- > 0) {
            long currentEle = pq.poll();
            pq.offer((long) Math.floor(Math.sqrt(currentEle)));
        }
        long result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }
        return result;
    }
}
