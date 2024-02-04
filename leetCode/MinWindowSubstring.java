package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-window-substring
 * 
 * @author subhrajeetghosh
 */
public class MinWindowSubstring {
    // Bruteforce approch
    public String minWindow_2ndMethod(String s, String t) { // time complexity - O(n*n)
        int[] charArray = new int[126];
        for (int i = 0; i < t.length(); i++) {
            charArray[t.charAt(i) - 'A']++;
        }
        int resultCount = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int tLength = 0;
            int[] charArrCopy = Arrays.copyOf(charArray, charArray.length);
            if (charArrCopy[s.charAt(i) - 'A'] > 0) {
                for (int j = i; j < s.length(); j++) {
                    if (charArrCopy[s.charAt(j) - 'A'] > 0) {
                        charArrCopy[s.charAt(j) - 'A']--;
                        tLength++;
                    }
                    if (tLength == t.length()) {
                        if (resultCount > j - i) {
                            result = s.substring(i, j + 1);
                            resultCount = j - i;
                        }
                    }
                }
            }
        }
        return result;
    }

    // Sliding Window
    public String minWindow(String s, String t) { // time complexity - O(n)
        int[] charArray = new int[58];
        for (int i = 0; i < t.length(); i++) {
            charArray[t.charAt(i) - 'A']++;
        }
        int resultCount = Integer.MAX_VALUE;
        String result = "";
        int tLen = t.length();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            charArray[s.charAt(i) - 'A']--;
            if (charArray[s.charAt(i) - 'A'] >= 0)
                tLen--;
            while (tLen == 0) {
                if (i - start < resultCount) {
                    result = s.substring(start, i + 1);
                    resultCount = i - start;
                }
                charArray[s.charAt(start) - 'A']++;
                if (charArray[s.charAt(start) - 'A'] > 0)
                    tLen++;
                start++;
            }
        }
        return result;
    }
}
