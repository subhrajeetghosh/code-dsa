package leetCode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/extra-characters-in-a-string
 * 
 * @author subhrajeetghosh
 */
public class ExtraCharInString {
    // memorized approch
    HashSet<String> dict;
    int[] memo;

    public int minExtraChar(String s, String[] dictionary) { // time complexity - O(n^2)
        dict = new HashSet<>(Arrays.asList(dictionary));
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return minLengthFinder(s, 0);
    }

    private int minLengthFinder(String s, int start) {
        if (start == s.length())
            return 0;
        if (memo[start] != -1)
            return memo[start];
        int result = 1 + minLengthFinder(s, start + 1);
        for (int end = start + 1; end <= s.length(); end++) {
            String currentSubstr = s.substring(start, end);
            if (dict.contains(currentSubstr)) {
                result = Math.min(result, minLengthFinder(s, end));
            }
        }
        memo[start] = result;
        return result;
    }
}
