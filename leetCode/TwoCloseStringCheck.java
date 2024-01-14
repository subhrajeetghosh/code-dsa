package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close
 * 
 * @author subhrajeetghosh
 */
public class TwoCloseStringCheck {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int[] firstCount = new int[26];
        int[] secondCount = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            firstCount[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            secondCount[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (firstCount[i] == 0 && secondCount[i] != 0 ||
                    firstCount[i] != 0 && secondCount[i] == 0) {
                return false;
            }
        }
        Arrays.sort(firstCount);
        Arrays.sort(secondCount);
        return Arrays.equals(firstCount, secondCount);
    }
}
