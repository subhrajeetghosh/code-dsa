package dynamicprogrammingcourse;

/**
 * Write a function bestSum(arr, target) that takes in targetSum and an array of
 * number as argument
 * The function should return an array indicating whether or not it is possible
 * to generate targetSum with the sortest array length possible
 * using the subset of array from the given array.
 * you may use an element from the array multiple times
 * you may assume all intgers number are non negative
 * 
 * @author subhrajeetghosh
 */

public class FindTargetBestSum {
    public int[] bestSum(int targetSum, int[] arr) {
        int[][] targetSumArray = new int[targetSum + 1][];
        targetSumArray[0] = new int[0];
        for (int i = 0; i <= targetSum; i++) {
            if (targetSumArray[i] != null) {
                for (int j = 0; j < arr.length; j++) {
                    if (i + arr[j] <= targetSum) {
                        if (targetSumArray[i + arr[j]] != null) {
                            if (targetSumArray[i + arr[j]].length > targetSumArray[i].length + 1) {
                                targetSumArray[i + arr[j]] = copyArraysData(targetSumArray[i], arr[j]);
                            }
                        } else {
                            targetSumArray[i + arr[j]] = copyArraysData(targetSumArray[i], arr[j]);
                        }
                    }
                }
            }
        }
        return targetSumArray[targetSum];
    }

    private int[] copyArraysData(int[] originalArray, int lastIndex) {
        int[] copyArray = new int[originalArray.length + 1];
        for (int i = 0; i < originalArray.length; i++) {
            copyArray[i] = originalArray[i];
        }
        copyArray[copyArray.length - 1] = lastIndex;
        return copyArray;
    }

    public static void main(String[] args) {
        int[] result = new FindTargetBestSum().bestSum(15, new int[] { 3, 5});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
