package leetCode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 * 
 * @author subhrajeetghosh
 */
public class MaxLenConcatString {
    public int maxLength(List<String> arr) { // time copmlexity - O(2^n)
        return checkLength(arr, 0, 0, new int[26]);
    }

    private int checkLength(List<String> arr, int index, int sum, int[] visit) {
        if (index >= arr.size())
            return sum;
        int[] currentVisit = Arrays.copyOf(visit, visit.length);
        int currentSum = 0;
        if (!hasSeen(currentVisit, arr.get(index))) {
            currentSum += checkLength(arr, index + 1, sum + arr.get(index).length(), currentVisit);
        }
        sum = Math.max(currentSum, checkLength(arr, index + 1, sum, visit));
        return sum;
    }

    private boolean hasSeen(int[] visit, String str) {
        for (char c : str.toCharArray()) {
            if (visit[c - 'a'] > 0) {
                return true;
            }
            visit[c - 'a']++;
        }
        return false;
    }
}
