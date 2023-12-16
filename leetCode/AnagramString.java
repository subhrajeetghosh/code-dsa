package leetCode;

/**
 * https://leetcode.com/problems/valid-anagram
 * 
 * @author Subhrajeet Ghosh
 */
public class AnagramString {
    public boolean isAnagram(String s, String t) { // time complexity - O(n), n -> length os any string
        if (s.length() != t.length())
            return false;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0)
                return false;
        }
        return true;
    }
}
