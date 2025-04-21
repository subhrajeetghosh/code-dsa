package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-the-hidden-sequences
 * 
 * @author subhrajeetghosh
 */
public class CountHiddenSequences {

    // Memorization
    Map<String, Integer> memo = new HashMap<>();

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int result = 0;
        for (int i = lower; i <= upper; i++) {
            result += findCombination(differences, lower, upper, i, 0);
        }
        return result;
    }

    private int findCombination(int[] diff, int lower, int upper, int currentNum, int index) {
        String key = currentNum + " " + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (currentNum < lower || currentNum > upper) {
            return 0;
        }
        if (index >= diff.length) {
            return 1;
        }
        int currentResult = findCombination(diff, lower, upper, currentNum + diff[index], index + 1);
        memo.put(key, currentResult);
        return currentResult;
    }

    // iterative approch
    public int numberOfArrays_2ndMethod(int[] differences, int lower, int upper) { // time complexity - O(mn)
        int result = 0;
        for (int i = lower; i <= upper; i++) {
            result += findCombination(differences, lower, upper, i);
        }
        return result;
    }

    private int findCombination(int[] diff, int lower, int upper, int currentNum) {
        for (int i = 0; i < diff.length; i++) {
            currentNum += diff[i];
            if (currentNum < lower || currentNum > upper)
                return 0;
        }
        return 1;
    }

    public int numberOfArrays_3rdMethod(int[] differences, int lower, int upper) { // time complexity - O(n)
        int left = 0, right = 0, currentLeft = 0, currentRight = 0;
        for (int i = 0; i < differences.length; i++) {
            currentLeft += differences[i];
            currentRight += differences[i];
            left = Math.min(left, currentLeft);
            right = Math.max(right, currentRight);
            if (right - left > upper - lower)
                return 0;
        }
        return (upper - lower) - (right - left) + 1;
    }
}
