package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii
 * 
 * @author subhrajeetghosh
 */
public class CountSubStrKConstAndVowel {
    // Brute force approach
    public long countOfSubstrings(String word, int k) { // time complexity - O(n^2)
        long result = 0;
        for (int left = 0; left < word.length(); left++) {
            int consonantCount = 0;
            Set<Character> vowelSet = new HashSet<>();
            for (int right = left; right < word.length(); right++) {
                if (isVowel(word.charAt(right))) {
                    vowelSet.add(word.charAt(right));
                } else {
                    consonantCount++;
                }
                if (consonantCount > k) {
                    break;
                }
                if (consonantCount == k && vowelSet.size() == 5) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public long countOfSubstrings_2ndMethod(String word, int k) { // time complexity - O(n)
        return atLeastKConstWithVowel(word, k) - atLeastKConstWithVowel(word, k + 1);
    }

    private long atLeastKConstWithVowel(String word, int k) {
        long result = 0;
        int start = 0, end = 0, consonant = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        while (end < word.length()) {
            char currentChar = word.charAt(end++);
            if (isVowel(currentChar)) {
                charMap.put(currentChar, charMap.getOrDefault(currentChar, 0) + 1);
            } else {
                consonant++;
            }
            while (charMap.size() == 5 && consonant >= k) {
                result += word.length() - end + 1;
                char startChar = word.charAt(start++);
                if (isVowel(startChar)) {
                    charMap.put(startChar, charMap.get(startChar) - 1);
                    if (charMap.get(startChar) == 0) {
                        charMap.remove(startChar);
                    }
                } else {
                    consonant--;
                }
            }
        }
        return result;
    }
}
