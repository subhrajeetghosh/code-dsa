/**
 * Write a function canSum(arr, target) that takes in targetSum and an array of
 * number as argument
 * The function should return a boolean indicating whether or not it is possible
 * to generate targetSum
 * using the number from array.
 * you may use an element from the array multiple times
 * you may assume all intgers number are non negative
 * 
 * @author Subhrajeet Ghosh
 */

public class FindTargetCanSum {
    public boolean findTargetSumIfPossible(int[] arr, int target) {
        return findTargetSum(arr, target, 0);
    }

    // Recusive way of Solving
    public boolean findTargetSum(int[] arr, int target, int index) {
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        if (index >= arr.length)
            return false;
        return findTargetSum(arr, target - arr[index], index)
                || findTargetSum(arr, target - arr[index], index + 1) || findTargetSum(arr, target, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 4, 7 };
        System.out.println(new FindTargetCanSum().findTargetSumIfPossible(arr, 7));
    }
}
