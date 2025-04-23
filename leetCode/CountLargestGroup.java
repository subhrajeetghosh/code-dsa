package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-largest-group
 * 
 * @author subhrajeetghosh
 */
public class CountLargestGroup {
    public int countLargestGroup(int n) { // time complexity - O(n log n)
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int i = 1; i <= n; i++) {
            int currentNum = i;
            int currentSum = 0;
            while (currentNum > 0) {
                currentSum += currentNum % 10;
                currentNum /= 10;
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
            maxCount = Math.max(maxCount, map.get(currentSum));
        }
        int result = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount) {
                result++;
            }
        }
        return result;
    }

    // optimized
    public int countLargestGroup_2ndMethod(int n) { // time complexity - O(n log n)
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0, maxCount = 0;
        for (int i = 1; i <= n; i++) {
            int currentNum = i;
            int currentSum = 0;
            while (currentNum > 0) {
                currentSum += currentNum % 10;
                currentNum /= 10;
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
            if (map.get(currentSum) > maxCount) {
                maxCount = map.get(currentSum);
                result = 1;
            } else if (map.get(currentSum) == maxCount) {
                result++;
            }
        }
        return result;
    }
}
