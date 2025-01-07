package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/string-matching-in-an-array
 * 
 * @author subhrajeetghosh
 */
public class StringMatchingInArray {
    public List<String> stringMatching(String[] words) { // time complexity - O(n * n * m)
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].indexOf(words[i]) != -1) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    // Another Approch
    public List<String> stringMatching_2ndMethod(String[] words) { // time complexity - O(n log n + n^2 m)
        List<String> result = new ArrayList<String>();
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    class Trie {
        int freq;
        Map<Character, Trie> children;

        public Trie() {
            freq = 0;
            children = new HashMap<Character, Trie>();
        }
    }

    public List<String> stringMatching_3rdMethod(String[] words) { // time complexity - O(n m^2)
        List<String> result = new ArrayList<>();
        Trie root = new Trie();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                insertTrie(root, word.substring(i));
            }
        }
        for (String string : words) {
            if (isFound(string, root)) {
                result.add(string);
            }
        }
        return result;
    }

    private void insertTrie(Trie node, String word) {
        for (Character c : word.toCharArray()) {
            node.children.putIfAbsent(c, new Trie());
            node = node.children.get(c);
            node.freq++;
        }
    }

    private boolean isFound(String str, Trie node) {
        for (Character c : str.toCharArray()) {
            node = node.children.get(c);
        }
        return node.freq > 1;
    }
}
