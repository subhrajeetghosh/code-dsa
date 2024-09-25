package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/sum-of-prefix-scores-of-strings
 * 
 * @author subhrajeetghosh
 */
public class SumPrefixScoreString {
    // Bruteforce Approch
    public int[] sumPrefixScores_2ndMethod(String[] words) { // time complexity - O(n * l^2)
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            for (int i = 1; i <= str.length(); i++) {
                String currentStrHash = str.substring(0, i);
                map.put(currentStrHash, map.getOrDefault(currentStrHash, 0) + 1);
            }
        }
        int[] result = new int[words.length];
        for (int i = 0; i < result.length; i++) {
            String currentStr = words[i];
            int sum = 0;
            for (int j = 1; j <= currentStr.length(); j++) {
                String currentStrHash = currentStr.substring(0, j);
                sum += map.get(currentStrHash);
            }
            result[i] = sum;
        }
        return result;
    }

    public int[] sumPrefixScores(String[] words) { // time complexity = O(n * l)
        Trie root = new Trie();
        for (String word : words) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                if (!node.childNode.containsKey(c)) {
                    node.childNode.put(c, new Trie());
                }
                node = node.childNode.get(c);
                node.count++;
            }
        }
        int[] result = new int[words.length];
        int index = 0;
        for (String word : words) {
            int sum = 0;
            Trie node = root;
            for (char c : word.toCharArray()) {
                node = node.childNode.get(c);
                sum += node.count;
            }
            result[index++] = sum;
        }
        return result;
    }
}

/**
 * InnerSumPrefixScoreString
 */
class Trie {
    Map<Character, Trie> childNode = new HashMap<>();
    int count;
}
