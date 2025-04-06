package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/largest-divisible-subset
 * 
 * @author subhrajeetghosh
 */
public class LargestDivisibleSubSet {
    List<Integer> resultSet;

    public List<Integer> largestDivisibleSubset_2ndMethod(int[] nums) {
        resultSet = new ArrayList<>();
        Arrays.sort(nums);
        findLargestSubSet(nums, 0, new ArrayList<>());
        return resultSet;
    }

    private void findLargestSubSet(int[] nums, int index, List<Integer> currentSet) { // time complexity - O(2^n)
        if (resultSet.size() < currentSet.size()) {
            resultSet = new ArrayList<>(currentSet);
        }
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (canAdd(nums[i], currentSet)) {
                currentSet.add(nums[i]);
                findLargestSubSet(nums, i + 1, currentSet);
                currentSet.remove(currentSet.size() - 1);
            }
        }
    }

    private boolean canAdd(int num, List<Integer> subSet) {
        if (subSet.isEmpty())
            return true;
        int last = subSet.get(subSet.size() - 1);
        return num % last == 0;
    }

    Map<Integer, List<Integer>> memo;

    //Memorization
    public List<Integer> largestDivisibleSubset(int[] nums) { //time complexity - O(n^2)
        memo = new HashMap<Integer, List<Integer>>();
        Arrays.sort(nums);
        return backtrack(nums, -1, 0);
    }

    private List<Integer> backtrack(int[] nums, int prevIndex, int index) {
        if (index == nums.length) {
            return new ArrayList<>();
        }
        int key = prevIndex * (nums.length + 1) + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        List<Integer> maxTake = new ArrayList<>();
        for (int i = index; i < nums.length; i++) {
            List<Integer> currentTake = new ArrayList<>();
            if (prevIndex == -1 || nums[i] % nums[prevIndex] == 0) {
                List<Integer> take = backtrack(nums, i, i + 1);
                currentTake = new ArrayList<>(take);
                currentTake.add(0, nums[i]);
            }
            if (maxTake.size() < currentTake.size()) {
                maxTake = new ArrayList<>(currentTake);
            }
        }
        memo.put(key, maxTake);
        return maxTake;
    }
}
