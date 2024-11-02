package leetCode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximal-score-after-applying-k-operations
 * 
 * @author subhrajeetghosh
 */
public class MaxScoreKOperation {
    public long maxKelements(int[] nums, int k) { // time complexity - O((n + k) log n)
        long res = 0l;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer num : nums) {
            pq.add(num);
        }
        while (k-- > 0) {
            int currentVal = pq.poll();
            res += currentVal;
            pq.add((int) Math.ceil((double) currentVal / 3));
        }
        return res;
    }
}
