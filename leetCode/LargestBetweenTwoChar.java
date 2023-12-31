package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters
 * 
 * @author subhrajeetghosh
 */

public class LargestBetweenTwoChar {

    public int maxLengthBetweenEqualCharacters(String s) { // optimized
        for (int i = s.length() - 1; i > 0; i--) {
            for (int j = 0; i + j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i + j))
                    return i - 1;
            }
        }
        return -1;
    }

    public int maxLengthBetweenEqualCharacters_2nd(String s) { // time complexity - O(n)
        Map<Character, Integer> indexStr = new HashMap<Character, Integer>();
        char[] charArray = s.toCharArray();
        int result = 0;
        boolean isTwoCharExist = false;
        for (int i = 0; i < charArray.length; i++) {
            if (indexStr.containsKey(charArray[i])) {
                int previousIndex = indexStr.get(charArray[i]);
                result = Math.max(result, i - previousIndex - 1);
                isTwoCharExist = true;
            } else {
                indexStr.put(charArray[i], i);
            }
        }
        return isTwoCharExist ? result : -1;
    }
}
