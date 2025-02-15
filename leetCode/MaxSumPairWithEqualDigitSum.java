package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits
 * 
 * @author subhrajeetghosh
 */
public class MaxSumPairWithEqualDigitSum {
    public int maximumSum(int[] nums) { // time complexity - O(n * log k)
        Map<Integer, LocalPair> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentDigitSum = getDigitSum(nums[i]);
            if (!map.containsKey(currentDigitSum)) {
                map.put(currentDigitSum, new LocalPair(-1, -1));
            }
            LocalPair currentPair = map.get(currentDigitSum);
            if (currentPair.first == -1) {
                currentPair.first = nums[i];
            } else if (currentPair.second == -1) {
                currentPair.second = nums[i];
            } else if (currentPair.first < currentPair.second && currentPair.first < nums[i]) {
                currentPair.first = nums[i];
            } else if (currentPair.second < nums[i]) {
                currentPair.second = nums[i];
            }
            map.put(currentDigitSum, new LocalPair(currentPair.first, currentPair.second));
        }
        int result = -1;
        for (int key : map.keySet()) {
            LocalPair currentPair = map.get(key);
            if (currentPair.first != -1 && currentPair.second != -1) {
                result = Math.max(result, map.get(key).first + map.get(key).second);
            }

        }
        return result;
    }

    public int maximumSum_2ndMethod(int[] nums) {
        @SuppressWarnings("unchecked")
        PriorityQueue<Integer>[] group = (PriorityQueue<Integer>[]) new PriorityQueue[82];
        for (int i = 0; i < 82; i++) {
            group[i] = new PriorityQueue<>();
        }
        for (int i = 0; i < nums.length; i++) {
            int currentDigitSum = getDigitSum(nums[i]);
            group[currentDigitSum].add(nums[i]);
            if (group[currentDigitSum].size() > 2) {
                group[currentDigitSum].poll();
            }
        }
        int result = -1;
        for (PriorityQueue<Integer> pq : group) {
            if (pq.size() == 2) {
                result = Math.max(result, pq.poll() + pq.poll());
            }
        }
        return result;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    class LocalPair {
        int first;
        int second;

        public LocalPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
