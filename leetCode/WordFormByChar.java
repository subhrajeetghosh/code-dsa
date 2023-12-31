package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters
 * 
 * @author subhrajeetghosh
 */

public class WordFormByChar {

    public int countCharacters(String[] words, String chars) {  // time complexity - O(N + K * M) 
        int result = 0;                                         // N -> chars.length K -> words.length
        int[] chrArray = new int[26];                           // M -> maxWord.length
        for (int i = 0; i < chars.length(); i++) {
            chrArray[chars.charAt(i) - 'a']++;
        }
        for (String word : words) {
            int currentCount = word.length();
            int[] currentChrArray = Arrays.copyOf(chrArray, chrArray.length);
            for (int i = 0; i < word.length(); i++) {
                if (currentChrArray[word.charAt(i) - 'a'] <= 0) {
                    currentCount = 0;
                } else {
                    currentChrArray[word.charAt(i) - 'a']--;
                }
            }
            result += currentCount;
        }
        return result;
    }



}
