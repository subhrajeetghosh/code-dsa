package dynamicprogrammingcourse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function canSum(arr, target) that takes in targetSum and an array of
 * number as argument
 * The function should return an array containing the sortest combination of
 * number
 * which add upto exactly targetSum
 * you may use an element from the array multiple times
 * you may assume all intgers number are non negative
 * 
 * @author subhrajeetghosh
 */

public class FindSortestTargetSum {
    int count = 0;
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<Integer> result;

    public List<Integer> finsTargetSumArray(int[] nums, int target) {
        if (nums.length == 0)
            return new ArrayList<>();
        result = findSortestPath_2ndMethod(nums, target);
        return result;
    }

    public void findSortestPath(int[] nums, int index, List<Integer> currentItem,
            int target, int currentCount) {
        if (target == 0 && (count == 0 || count > currentCount)) {
            count = currentCount;
            result = new ArrayList<>(currentItem);
        }
        if (index >= nums.length || (count != 0 && count <= currentCount) || target < 0) {
            return;
        }
        List<Integer> newCurrnetItem = new ArrayList<>(currentItem);
        newCurrnetItem.add(nums[index]);
        findSortestPath(nums, index, newCurrnetItem, target - nums[index], currentCount + 1);
        findSortestPath(nums, index + 1, newCurrnetItem, target - nums[index], currentCount + 1);
        findSortestPath(nums, index + 1, currentItem, target, currentCount);
    }

    // Momorization
    public List<Integer> findSortestPath_2ndMethod(int[] nums, int target) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == 0) {
            return new ArrayList<>();
        } else if (target < 0) {
            return null;
        }
        List<Integer> sortestPathList = null;
        for (int num : nums) {
            int newTarget = target - num;
            List<Integer> combinationList = findSortestPath_2ndMethod(nums, newTarget);
            if (combinationList != null) {
                combinationList.add(num);
                if (sortestPathList == null || sortestPathList.size() > combinationList.size()) {
                    sortestPathList = new ArrayList<>(combinationList);
                }
            }
        }
        if (sortestPathList == null) {
            sortestPathList = new ArrayList<>();
        }
        map.put(target, new ArrayList<>(sortestPathList));
        return sortestPathList;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5 };

        List<Integer> listOfSmallestData = new FindSortestTargetSum().finsTargetSumArray(arr, 8);
        for (Integer integer : listOfSmallestData) {
            System.out.print(integer + " ");
        }
    }
}
