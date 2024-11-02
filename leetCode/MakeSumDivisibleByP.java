package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/make-sum-divisible-by-p/
 * 
 * @author subhrajeetghosh
 */
public class MakeSumDivisibleByP {
    int longestLen = 0;
    Map<String, Integer> memo = new HashMap<>();

    public int minSubarray_1(int[] nums, int p) {
        backTrack(nums, p, 0, 0, 0L);
        return longestLen == 0 ? -1 : nums.length - longestLen;
    }

    private int backTrack(int[] nums, int p, int index, int count, long sum) {
        String key = index + "," + sum;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (sum % p == 0) {
            longestLen = Math.max(longestLen, count);
        }

        if (index >= nums.length) {
            return 0;
        }

        int include = backTrack(nums, p, index + 1, count + 1, sum + nums[index]);
        int exclude = backTrack(nums, p, index + 1, count, sum);

        int result = Math.max(include, exclude);
        memo.put(key, result);

        return result;
    }

    public int minSubarray(int[] nums, int p) {
        int total = 0, result = nums.length;
        for (int num : nums) {
            total += num;
        }

        int target = total % p;

        if (target == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = (currentSum + nums[i]) % p;
            int needed = (currentSum - target + p) % p;

            if (map.containsKey(needed)) {
                result = Math.min(result, i - map.get(needed));
            }

            map.put(currentSum, i);
        }
        return result == nums.length ? -1 : result;
    }

    public static void main(String[] args) {
        System.out.println(new MakeSumDivisibleByP().minSubarray(
                new int[] { 26, 19, 11, 14, 18, 4, 7, 1, 30, 23, 19, 8, 10, 6, 26, 3 },
                26));
    }
}
