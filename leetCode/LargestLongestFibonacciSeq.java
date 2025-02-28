package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence
 * 
 * @author subhrajeetghosh
 */
public class LargestLongestFibonacciSeq {
    Map<Integer, Integer> indexMap;
    int result = 0;

    public int lenLongestFibSubseq(int[] arr) { // time complexity - O(n^2) worst case O(n^3)
        indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                getFibo(arr, i, j, 2);
            }
        }
        return result;
    }

    private void getFibo(int[] arr, int i, int j, int length) {
        int nextElement = arr[i] + arr[j];
        if (indexMap.containsKey(nextElement) && indexMap.get(nextElement) > j) {
            getFibo(arr, j, indexMap.get(nextElement), length + 1);
        } else {
            if (length > 2) {
                result = Math.max(result, length);
                return;
            }
        }
    }
}
