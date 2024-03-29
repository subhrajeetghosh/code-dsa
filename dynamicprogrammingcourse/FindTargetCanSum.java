package dynamicprogrammingcourse;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function canSum(arr, target) that takes in targetSum and an array of
 * number as argument
 * The function should return a boolean indicating whether or not it is possible
 * to generate targetSum
 * using the number from array.
 * you may use an element from the array multiple times
 * you may assume all intgers number are non negative
 * 
 * @author subhrajeetghosh
 */

public class FindTargetCanSum {
    Map<Integer, Boolean> map = new HashMap<>();

    public boolean findTargetSumIfPossible(int[] arr, int target) {
        return findTargetSum(arr, target, 0);
    }

    // Recusive way of Solving with Memorization
    public boolean findTargetSum(int[] arr, int target, int index) {
        if (map.containsKey(target))
            return map.get(target);
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        if (index >= arr.length)
            return false;
        map.put(target, findTargetSum(arr, target - arr[index], index)
                || findTargetSum(arr, target - arr[index], index + 1) || findTargetSum(arr, target, index + 1));
        return map.get(target);
    }

    // dynamic approch tabulation
    public boolean findTargetSum_Tabulation(int[] arr, int targetSum) {
        boolean[] targetSumArr = new boolean[targetSum + 1];
        targetSumArr[0] = true;
        for (int i = 0; i < targetSumArr.length; i++) {
            if (targetSumArr[i]) {
                for (int j = 0; j < arr.length; j++) {
                    if (i + arr[j] < targetSumArr.length) {
                        targetSumArr[i + arr[j]] = true;
                    }
                }
            }
        }
        return targetSumArr[targetSum];
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3 };
        System.out.println(new FindTargetCanSum().findTargetSumIfPossible(arr, 7));
        System.out.println(new FindTargetCanSum().findTargetSum_Tabulation(arr, 7));
    }
}
