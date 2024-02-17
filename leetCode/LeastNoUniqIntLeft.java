package leetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals
 * 
 * @author subhrajeetghosh
 */
public class LeastNoUniqIntLeft {
    // Bruteforce approch
    public int findLeastNumOfUniqueInts(int[] arr, int k) { // time complexity - O(n^2)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        while (k > 0 || !map.isEmpty()) {
            int currentNumber = -1;
            int minVal = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (minVal > entry.getValue()) {
                    minVal = entry.getValue();
                    currentNumber = entry.getKey();
                }
            }
            if (k - minVal < 0)
                break;
            k -= minVal;
            map.remove(currentNumber);
        }
        return map.size();
    }

    public int findLeastNumOfUniqueInts_2ndMethod(int[] arr, int k) { // time complexity -
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<UniqueTrack> pq = new PriorityQueue<>(Comparator.comparing(q -> q.count));
        map.forEach((key, value) -> pq.add(new UniqueTrack(value, key)));
        while (!pq.isEmpty() || k > 0) {
            UniqueTrack uniqueTrack = pq.poll();
            if(k - uniqueTrack.count < 0) break;
            k -= uniqueTrack.count;
            map.remove(uniqueTrack.number);
        }
        return map.size();
    }
}

/**
 * UniqueTrack
 */
class UniqueTrack {
    int count;
    int number;

    public UniqueTrack(int count, int number) {
        this.count = count;
        this.number = number;
    }
}
