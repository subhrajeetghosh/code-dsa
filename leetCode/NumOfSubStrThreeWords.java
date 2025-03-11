package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters
 * 
 * @author subhrajeetghosh
 */
public class NumOfSubStrThreeWords {
    public int numberOfSubstrings(String s) { // time complexity - O(n)
        int start = 0, end = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length() || map.size() == 3) {
            if (end < s.length()) {
                char currentChar = s.charAt(end++);
                map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            }
            while (map.size() == 3) {
                result += s.length() - end + 1;
                char startingChar = s.charAt(start++);
                map.put(startingChar, map.get(startingChar) - 1);
                if (map.get(startingChar) == 0) {
                    map.remove(startingChar);
                }
            }
        }
        return result;
    }

    // optimized solution
    public int numberOfSubstrings_2ndMethod(String s) { // time complexity - O(n)
        int[] position = { -1, -1, -1 };
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            position[s.charAt(i) - 'a'] = i;
            result += 1 + Math.min(position[0], Math.min(position[1], position[2]));
        }
        return result;
    }
}
