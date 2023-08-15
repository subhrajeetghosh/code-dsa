package leetCode;
/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 * 
 * @author Subhrajeet Ghosh
 */

public class MaxVowelSubString {
    // Brute Force Approch
    public int maxVowels_2ndMethod(String s, int k) {
        int maxVowels = 0;
        for (int i = 0; i <= s.length() - k; i++) {
            int index = i;
            int currenVowels = 0;
            while (index < i + k) {
                if (isCharVowelCheck(s.charAt(index))) {
                    currenVowels++;
                }
                index++;
            }
            maxVowels = Math.max(currenVowels, maxVowels);
        }
        return maxVowels;
    }

    // Two Pointer
    // Optimized Approched
    public int maxVowels(String s, int k) {
        int i = 0;
        int j = k - 1;
        int maxVowels = 0;
        for (int index = 0; index < k; index++) {
            if (isCharVowelCheck(s.charAt(index))) {
                maxVowels++;
            }
        }
        int currentCount = maxVowels;
        while (j < s.length() - 1) {
            if (isCharVowelCheck(s.charAt(i))) {
                currentCount--;
            }
            i++;
            if (isCharVowelCheck(s.charAt(j + 1))) {
                currentCount++;
            }
            j++;
            maxVowels = Math.max(maxVowels, currentCount);
        }
        return maxVowels;
    }

    private boolean isCharVowelCheck(char vowel) {
        return vowel == 'a' || vowel == 'e' || vowel == 'i' || vowel == 'o'
                || vowel == 'u';
    }
}
