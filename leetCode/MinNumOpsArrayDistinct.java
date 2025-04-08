package leetCode;

import java.util.HashMap;
import java.util.Map;

public class MinNumOpsArrayDistinct {
    public int minimumOperations(int[] nums) { // time complexity - O(n)
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        int currentIndex = 0, result = 0;
        while (true) {
            boolean isCheck = false;
            if (numMap.size() < nums.length - currentIndex) {
                result++;
                int nextStop = currentIndex + 3;
                while (currentIndex < nums.length && currentIndex < nextStop) {
                    isCheck = true;
                    numMap.put(nums[currentIndex], numMap.get(nums[currentIndex]) - 1);
                    if (numMap.get(nums[currentIndex]) == 0) {
                        numMap.remove(nums[currentIndex]);
                    }
                    currentIndex++;
                }
            } else {
                break;
            }
            if (!isCheck)
                break;
        }
        return result;
    }

    public int minimumOperations_concise(int[] nums) { // time complexity - O(n)
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int operations = 0;
        int processed = 0;

        while (processed < nums.length) {
            if (freq.size() < nums.length - processed) {
                operations++;
                int limit = Math.min(nums.length, processed + 3);
                while (processed < limit) {
                    int currentNum = nums[processed++];
                    if (freq.put(currentNum, freq.get(currentNum) - 1) == 1) {
                        freq.remove(currentNum);
                    }
                }
            } else {
                break;
            }
        }
        return operations;
    }

    // Optimized
    public int minimumOperations_3rdMethod(int[] nums) { // time complexity - O(n)
        boolean[] seen = new boolean[128];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (seen[nums[i]])
                return i / 3 + 1;
            seen[nums[i]] = true;
        }
        return 0;
    }
}
