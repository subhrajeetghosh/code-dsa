package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i
 * 
 * @author subhrajeetghosh
 */
public class LongestSplSubString {
    public int maximumLength(String s) { // time complexity - O(n^3)
        if (s.length() == 0)
            return -1;
        for (int i = s.length(); i > 0; i--) {
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j <= s.length() - i; j++) {
                String subString = s.substring(j, j + i);
                if (checkSubString(subString)) {
                    map.put(subString, map.getOrDefault(subString, 0) + 1);
                }
            }
            for (String key : map.keySet()) {
                if (map.get(key) >= 3) {
                    return key.length();
                }
            }
        }
        return -1;
    }

    private boolean checkSubString(String str) {
        char firstChar = str.charAt(0);
        for (char c : str.toCharArray()) {
            if (firstChar != c) {
                return false;
            }
        }
        return true;
    }
}
