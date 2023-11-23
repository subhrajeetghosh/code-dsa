package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-nice-pairs-in-an-array
 * 
 * @author subhrajeetghosh
 */

public class CountNicePair {

    // BruteForce Approch
    public int countNicePairs(int[] nums) {
        int[] revVal = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            revVal[i] = getRevVal(nums[i]);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + revVal[j] == nums[j] + revVal[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Optimized Approch
    public int countNicePairs_2ndMethod(int[] nums) {
        int[] revVal = new int[nums.length];
        int count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            revVal[i] = getRevVal(nums[i]);
            int difference = nums[i] - revVal[i];
            count += freqMap.getOrDefault(difference, 0);
            count %= 1_000_000_007;
            freqMap.put(difference, freqMap.getOrDefault(difference, 0) + 1);
        }
        return count;
    }

    private int getRevVal(int num) {
        return Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());
    }

    public static void main(String[] args) {
        new CountNicePair().countNicePairs(new int[] { 42, 11, 10, 97 });
    }
}
