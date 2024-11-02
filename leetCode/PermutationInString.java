package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/permutation-in-string
 * 
 * @author subhrajeetghosh
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) { // time complexity - O(n) avoid indexOf
        int[] arr = new int[26];
        for (char c : s1.toCharArray()) {
            arr[c - 'a']++;
        }
        int[] copyArr = Arrays.copyOf(arr, arr.length);

        int start = 0, end = 0, currentLen = 0;
        char[] s2Arr = s2.toCharArray();

        while (end < s2.length()) {

            if (arr[s2Arr[end] - 'a'] > 0) {
                currentLen++;
                arr[s2Arr[end++] - 'a']--;
            } else if (s1.indexOf(s2Arr[end]) != -1) {
                currentLen--;
                arr[s2Arr[start] - 'a']++;
                start++;
            } else {
                arr = Arrays.copyOf(copyArr, copyArr.length);
                currentLen = 0;
                end++;
                start = end;
            }

            if (currentLen == s1.length())
                return true;
        }
        return false;
    }
}
