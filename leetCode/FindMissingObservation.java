package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-missing-observations/description/
 * 
 * @author subhrajeetghosh
 */
public class FindMissingObservation {
    int[] result;
    boolean isResulted = false;

    // backtracking
    public int[] missingRolls_2ndMethod(int[] rolls, int mean, int n) { // time complexity - O(m + 6^n)
        int m = rolls.length;
        int mObs = 0;
        for (int roll : rolls) {
            mObs += roll;
        }
        int totalObservation = m + n;
        int totalVal = mean * totalObservation;
        int valueToGet = totalVal - mObs;
        if (valueToGet < n || valueToGet > 6 * n)
            return new int[0];
        result = new int[n];
        dfs(valueToGet, 0, new int[n]);
        return isResulted ? result : new int[0];
    }

    private void dfs(int value, int index, int[] arr) {
        if (isResulted)
            return;
        if (value == 0 && index == arr.length) {
            isResulted = true;
            result = Arrays.copyOf(arr, arr.length);
            return;
        }
        if (value < 0 || index >= arr.length) {
            return;
        }
        for (int i = 1; i <= 6; i++) {
            if (value - i < arr.length - (index + 1) || value - i > (arr.length - (index + 1)) * 6) {
                continue;
            }

            arr[index] = i;
            dfs(value - i, index + 1, arr);
            arr[index] = 0;
        }
    }

    // optimized solution
    public int[] missingRolls(int[] rolls, int mean, int n) { // time complexity - O(n)
        int m = rolls.length;
        int mObs = 0;
        for (int roll : rolls) {
            mObs += roll;
        }
        int totalObservation = m + n;
        int totalVal = mean * totalObservation;
        int valueToGet = totalVal - mObs;
        if (valueToGet < n || valueToGet > 6 * n)
            return new int[0];
        int[] result = new int[n];
        int commonPart = valueToGet / n, rem = valueToGet % n;
        Arrays.fill(result, commonPart);
        for (int i = 0; i < rem; i++) {
            result[i]++;
        }
        return result;
    }
}
