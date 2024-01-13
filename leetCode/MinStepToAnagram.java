package leetCode;

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram
 * 
 * @author subhrajeetghosh
 */
public class MinStepToAnagram {
    public int minSteps(String s, String t) { // time complexity - O(n)
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int commonCount = 0;
        for (int i = 0; i < t.length(); i++) {
            if (arr[t.charAt(i) - 'a'] > 0) {
                commonCount++;
            }
            arr[t.charAt(i) - 'a']--;
        }
        return s.length() - commonCount;
    }

    //More Optimized same time complexity
    public int minSteps_2ndMethod(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        int uncommon = 0;
        for (int i : arr) {
            if (i > 0) {
                uncommon += i;
            }
        }
        return uncommon;
    }
}
