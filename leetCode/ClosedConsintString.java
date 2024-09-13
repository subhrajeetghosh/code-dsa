package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/count-the-number-of-consistent-strings
 * 
 * @author subhrajeetghosh
 */
public class ClosedConsintString {
    public int countConsistentStrings(String allowed, String[] words) { //time complexity - O(n)
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }
        int result = 0;
        for (String word : words) {
            result++;
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    result--;
                    break;
                }
            }
        }
        return result;
    }
}
