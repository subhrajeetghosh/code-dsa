package leetCode;

import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i
 * 
 * @author subhrajeetghosh
 */
public class LongestUnEqualSubSeq {
    public List<String> getLongestSubsequence(String[] words, int[] groups) { // time complexity - O(n)
        List<String> result = new ArrayList<>();
        int group = groups[0];
        result.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (groups[i] != group) {
                result.add(words[i]);
                group = groups[i];
            }
        }
        return result;
    }
}
