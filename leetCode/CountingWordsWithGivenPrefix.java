package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/counting-words-with-a-given-prefix
 * 
 * @author subhrajeetghosh
 */
public class CountingWordsWithGivenPrefix {
    class Trie {
        int freq;
        Map<Character, Trie> children;

        public Trie() {
            freq = 0;
            children = new HashMap<>();
        }
    }

    public int prefixCount(String[] words, String pref) { //time complexity - O(n*l)
        Trie root = new Trie();
        for (String word : words) {
            insertTrie(word, root);
        }
        Trie node = root;
        for (Character c : pref.toCharArray()) {
            node = node.children.get(c);
            if (node == null)
                return 0;
        }
        return node.freq;
    }

    private void insertTrie(String word, Trie node) {
        for (Character c : word.toCharArray()) {
            node.children.putIfAbsent(c, new Trie());
            node = node.children.get(c);
            node.freq++;
        }
    }

    public int prefixCount_2ndMethod(String[] words, String pref) {
        int result = 0;
        for(String word : words) {
            if(word.startsWith(pref)) {
                result++;
            }
        }
        return result;
    }
}
