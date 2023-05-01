package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function canSum(arr, target) that takes in targetSum and an array of
 * number as argument
 * The function should return an array indicating whether or not it is possible
 * to generate targetSum
 * using the subset of array from the given array.
 * you may use an element from the array multiple times
 * you may assume all intgers number are non negative
 * 
 * @author Subhrajeet Ghosh
 */

public class FindTargetHowSum {
    Map<Integer, Boolean> map = new HashMap<>();
    List<Integer> finalList = new ArrayList<>();

    public List<Integer> findTargetHowSumArray(int target, int[] arr) {
        if (target == 0)
            return new ArrayList<Integer>();

        return isPossibleFindingSumArray(target, 0, arr, new ArrayList<>()) ? finalList : null;
    }

    public boolean isPossibleFindingSumArray(int target, int index, int[] arr, List<Integer> list) {
        if (map.containsKey(target))
            return map.get(target);
        if (index >= arr.length)
            return false;
        if (target == 0) {
            finalList = new ArrayList<>(list);
            return true;
        }
        if (target < 0)
            return false;
        List<Integer> newAddedList = new ArrayList<>(list);
        newAddedList.add(arr[index]);
        map.put(target, isPossibleFindingSumArray(target - arr[index], index, arr, newAddedList)
                || isPossibleFindingSumArray(target - arr[index], index + 1, arr, newAddedList)
                || isPossibleFindingSumArray(target, index + 1, arr, list));
        return map.get(target);
    }

    public static void main(String[] args) {
        int[] arr = { 7, 3, 5 };
        List<Integer> lst = new FindTargetHowSum().findTargetHowSumArray(8, arr);
        for (int i : lst) {
            System.out.println(i);
        }
    }
}
