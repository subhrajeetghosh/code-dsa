package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-length-3-palindromic-subsequences
 * 
 * @author subhrajeetghosh
 */
public class UniqueLenThreePalindrome {
    Map<String, Boolean> map;
    Set<String> set;

    public int countPalindromicSubsequence_2ndMethod(String s) { // time complexity - O(n^3)
        map = new HashMap<String, Boolean>();
        set = new HashSet<>();
        backtrack(s, 0, new StringBuilder());
        return set.size();
    }

    private boolean backtrack(String str, int index, StringBuilder currentString) {
        String key = index + "#" + currentString;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (currentString.length() == 3) {
            if (currentString.charAt(0) == currentString.charAt(2)) {
                set.add(currentString.toString());
                map.put(key, true);
                return true;
            }
            map.put(key, false);
            return false;
        }
        if (index >= str.length()) {
            return false;
        }
        currentString.append(str.charAt(index));
        backtrack(str, index + 1, currentString);
        currentString.deleteCharAt(currentString.length() - 1);
        backtrack(str, index + 1, currentString);
        map.put(key, false);
        return false;
    }

    // Optimized
    public int countPalindromicSubsequence_3rdMethod(String s) { //time complexity - O(n * 26)
        int result = 0;
        Integer[][] charArr = new Integer[26][2];
        for (int i = 0; i < s.length(); i++) {
            if (charArr[s.charAt(i) - 'a'][0] == null) {
                charArr[s.charAt(i) - 'a'][0] = i;
            } else {
                charArr[s.charAt(i) - 'a'][1] = i;
            }
        }
        for (Integer[] arr : charArr) {
            if (arr[0] != null && arr[1] != null && arr[1] - arr[0] > 1) {
                Set<Character> seen = new HashSet<>();
                for (int i = arr[0] + 1; i < arr[1]; i++) {
                    seen.add(s.charAt(i));
                }
                result += seen.size();
            }
        }
        return result;
    }
    
    //another approch
    public int countPalindromicSubsequence(String s) { //time complexity - O(n*26)
        int result = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int left = s.indexOf(c);
            int right = s.lastIndexOf(c);
            if (left == -1 || left == right)
                continue;

            Set<Character> set = new HashSet<>();
            for (int i = left + 1; i < right; i++) {
                set.add(s.charAt(i));
            }
            result += set.size();
        }
        return result;
    }
}
