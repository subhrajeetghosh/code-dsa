package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary
 * 
 * @author subhrajeetghosh
 */
public class NumberWaysToFormTarget {
    // Recursion
    int result = 0;

    public int numWays(String[] words, String target) {
        backtract(words, target, 0, 0);
        return result;
    }

    private void backtract(String[] words, String target, int targetIndex, int index) { // time complexity - O(m ^
                                                                                        // min(n,t))
        if (targetIndex >= target.length()) {
            result++;
            return;
        }
        if (index >= words[0].length()) {
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(index) == target.charAt(targetIndex)) {
                backtract(words, target, targetIndex + 1, index + 1);
            }
        }
        backtract(words, target, targetIndex, index + 1);
    }

    Map<String, Long> map;
    long mod = 1000000007;

    public int numWays_2ndMethod(String[] words, String target) { //time complexity - O(m*n + n*t) 
        map = new HashMap<>();
        long[][] freq = new long[words[0].length()][26];
        for (String word : words) {
            for (int i = 0; i < words[0].length(); i++) {
                freq[i][word.charAt(i) - 'a']++;
            }
        }
        return (int) backtrack(freq, target, 0, 0);
    }

    private long backtrack(long[][] freq, String target, int targetIndex, int index) {
        String key = index + "," + targetIndex;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (targetIndex >= target.length()) {
            return 1l;
        }
        if (index >= freq.length) {
            return 0l;
        }
        long count = 0l;
        if (freq[index][target.charAt(targetIndex) - 'a'] > 0) {
            count += (freq[index][target.charAt(targetIndex) - 'a']
                    * backtrack(freq, target, targetIndex + 1, index + 1));
            count %= mod;
        }
        count += backtrack(freq, target, targetIndex, index + 1);
        count %= mod;
        map.put(key, count);
        return map.get(key);
    }
}
