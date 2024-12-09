package leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/two-best-non-overlapping-events
 * 
 * @author subhrajeetghosh
 */
public class TwoBestNonOverlappingEvent {
    public int maxTwoEvents(int[][] events) { // time complexity - O(n log n + n*n)
        Arrays.sort(events, (a, b) -> b[2] - a[2]);
        int maxResult = 0;
        for (int i = 0; i < events.length; i++) {
            int currentValue = events[i][2];
            int maxPair = 0;
            for (int j = i + 1; j < events.length; j++) {
                if (events[i][0] < events[j][1] && events[i][1] < events[j][0] ||
                        events[i][0] > events[j][1] && events[i][1] > events[j][0]) {
                    maxPair = Math.max(maxPair, events[j][2]);
                }
            }
            maxResult = Math.max(currentValue + maxPair, maxResult);
        }
        return maxResult;
    }

    public int maxTwoEvents_2ndMethod(int[][] events) { // time complexity - O(n log n)
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int currentMax = 0, result = 0;
        for (int[] event : events) {
            while (!pq.isEmpty() && pq.peek()[0] < event[0]) {
                currentMax = Math.max(currentMax, pq.poll()[1]);
            }
            result = Math.max(result, event[2] + currentMax);
            pq.add(new int[] { event[1], event[2] });
        }
        return result;
    }
}
