package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words
 * 
 * @author subhrajeetghosh
 */
public class LongestPalindromConcatTwoWords {
    public int longestPalindrome(String[] words) { // time complexity - O(n * 2)
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        Set<String> visited = new HashSet<>();
        int maxSameCharCount = 0;
        int longestOutSide = 0;
        for (String key : map.keySet()) {
            if (!visited.contains(key)) {
                visited.add(key);
                if (key.charAt(0) == key.charAt(1)) {
                    if ((maxSameCharCount / 2) % 2 == 0 || map.get(key) % 2 == 0) {
                        maxSameCharCount += map.get(key) * 2;
                    } else {
                        maxSameCharCount += (map.get(key) - 1) * 2;
                    }
                } else {
                    String reverseKey = new StringBuilder(key).reverse().toString();
                    if (map.containsKey(reverseKey)) {
                        visited.add(reverseKey);
                        longestOutSide += Math.min(map.get(key), map.get(reverseKey)) * 4;
                    }
                }

            }
        }
        return longestOutSide + maxSameCharCount;
    }

}
