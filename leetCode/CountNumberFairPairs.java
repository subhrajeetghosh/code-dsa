package leetCode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CountNumberFairPairs {
    // Bruteforce approch
    public long countFairPairs_2ndMethod(int[] nums, int lower, int upper) { // time complexity - O (n log n + n^2)
        if (nums.length <= 1)
            return 0L;
        long result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int currentSum = nums[i] + nums[j];
                if (lower <= currentSum && upper >= currentSum) {
                    result++;
                } else if (upper < currentSum) {
                    break;
                }
            }
        }
        return result;
    }

    // Using TreeMap
    public long countFairPairs_3rdMethod(int[] nums, int lower, int upper) { // time complexity - O(n log n)
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        long result = 0;
        for (int num : nums) {
            int lowerRange = lower - num;
            int upperRange = upper - num;
            Map<Integer, Integer> subMap = map.subMap(lowerRange, true, upperRange, true);
            for (int count : subMap.values()) {
                result += count;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return result;
    }

    // Using Binery Search
    public long countFairPairs(int[] nums, int lower, int upper) { // time complexity - O(n log n)
        Arrays.sort(nums);
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            int lowerBound = lowerBound(nums, i + 1, lower - nums[i]);
            int upperBound = upperBound(nums, i + 1, upper - nums[i]);
            result += upperBound - lowerBound;
        }

        return result;
    }

    private int lowerBound(int[] nums, int left, int target) {
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int upperBound(int[] nums, int left, int target) {
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private int findIndex(int[] nums, int left, int element) {
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= element) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public long countFairPairs_4thMethod(int[] nums, int lower, int upper) { // time complexity - O(n log n)
        Arrays.sort(nums);
        long pair = 0l;
        for (int i = 0; i < nums.length; i++) {
            int lowerBound = findIndex(nums, i + 1, lower - nums[i]);
            int upperBound = findIndex(nums, i + 1, upper - nums[i] + 1);
            pair += (long) (upperBound - lowerBound);
        }
        return pair;
    }

    public long countFairPairs_TwoPointers(int[] nums, int lower, int upper) { // time complexity - O(n log n)
        Arrays.sort(nums);
        return countPairs(nums, upper + 1) - countPairs(nums, lower);
    }

    private long countPairs(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        long pair = 0l;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < value) {
                pair += right - left;
                left++;
            } else {
                right--;
            }
        }
        return pair;
    }
}
