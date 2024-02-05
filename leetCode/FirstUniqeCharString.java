package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string
 * 
 * @author subhrajeetghosh
 */
public class FirstUniqeCharString {

    public int firstUniqChar(String s) { // time complexity - O(n)
        Integer[] charStore = new Integer[26];
        char[] charArray = s.toCharArray();
        int index = 0;
        for (char c : charArray) {
            if (charStore[c - 'a'] != null && charStore[c - 'a'] >= 0 ||
                    (charStore[c - 'a'] != null && charStore[c - 'a'] == -1)) {
                charStore[c - 'a'] = -1;
            } else {
                charStore[c - 'a'] = index;
            }
            index++;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (charStore[i] != null && charStore[i] != -1) {
                result = Math.min(result, charStore[i]);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    // another approch
    public int firstUniqChar_2ndMthod(String s) {
        int[] arr = new int[26];
        Map<Integer, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            arr[charArray[i] - 'a']++;
            map.put(charArray[i] - 'a', i);
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 1) {
                result = Math.min(result, map.get(i));
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    // Faster Approch
    public int firstUniqChar_3rdMethod(String s) {
        int[] arr = new int[26];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            arr[charArray[i] - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[charArray[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
