package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-palindrome
 * 
 * @author subhrajeetghosh
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) { // time complexity - O(n)
        if (s.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                result += 2;
            } else
                set.add(c);
        }
        return set.size() == 0 ? result : result + 1;
    }
}
