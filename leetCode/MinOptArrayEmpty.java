package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty
 * 
 * @author subhrajeetghosh
 */
public class MinOptArrayEmpty {
    public int minOperations(int[] nums) { // time complexity - O(n)
        Map<Integer, Integer> numsCount = new HashMap<Integer, Integer>();
        for (int num : nums) {
            numsCount.put(num, numsCount.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (int key : numsCount.keySet()) {
            int currentCount = numsCount.get(key);
            while (currentCount > 0) {
                if (currentCount - 3 >= 0 && currentCount - 3 != 1) {
                    currentCount -= 3;
                } else if (currentCount - 2 >= 0) {
                    currentCount -= 2;
                } else {
                    return -1;
                }
                result++;
            }
        }
        return result;
    }
}

/*
 * time complexity explanation -
 * The first loop iterates through each element in the nums array and inserts or
 * updates entries in the numsCount map.
 * In the worst case, this loop has a time complexity of O(N), where N is the
 * length of the nums array.
 * The second loop iterates through each unique key in the numsCount map.
 * In the worst case, this loop also has a time complexity of O(N), where N is
 * the number of unique elements in nums.
 * The operations inside the loop are constant time. The while loop iterates a
 * constant number of times for each unique element.
 * Therefore, the overall time complexity of the function is O(N),
 * where N is the length of the nums array. The function makes a single pass
 * through the array and performs constant-time operations for each element and
 * each unique element.
 */