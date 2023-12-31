package leetCode;

/**
 * https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal
 * 
 * @author subhrajeetghosh
 */
public class RedistributeChar {
    public boolean makeEqual(String[] words) { // time compexity - O(m*n)
        int[] charStore = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                charStore[c - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (charStore[i] % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
