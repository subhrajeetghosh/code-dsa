package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-subsets
 * 
 * @author subhrajeetghosh
 */
public class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) { // time complexity - O(m*l1 + n*l2)
        int[] maxFreq = getMaxFreq(words2);
        List<String> result = new ArrayList<String>();
        for (String word : words1) {
            int[] currentWord = new int[26];
            for (char c : word.toCharArray()) {
                currentWord[c - 'a']++;
            }
            if (isSubSet(maxFreq, currentWord)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean isSubSet(int[] maxArr, int[] checkArr) {
        for (int i = 0; i < 26; i++) {
            if (maxArr[i] > checkArr[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getMaxFreq(String[] words) {
        int[] result = new int[26];
        for (String word : words) {
            int[] wordCount = new int[26];
            for (char c : word.toCharArray()) {
                wordCount[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                result[i] = Math.max(result[i], wordCount[i]);
            }
        }
        return result;
    }
}
