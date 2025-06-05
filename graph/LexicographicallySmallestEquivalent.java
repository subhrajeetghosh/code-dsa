package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
 * 
 * @author subhrajeetghosh
 */
public class LexicographicallySmallestEquivalent {
    public String smallestEquivalentString(String s1, String s2, String baseStr) { // time complexity - O(n + m * 26)
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            graph.putIfAbsent(ch1, new HashSet<>());
            graph.putIfAbsent(ch2, new HashSet<>());
            graph.get(ch1).add(ch2);
            graph.get(ch2).add(ch1);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char currentChar = '\0';
            Queue<Character> queue = new LinkedList<>();
            queue.add(baseStr.charAt(i));
            Set<Character> set = new HashSet<>();
            while (!queue.isEmpty()) {
                char currentNode = queue.poll();
                if (set.contains(currentNode) || !graph.containsKey(currentNode))
                    continue;
                set.add(currentNode);
                for (char ch : graph.get(currentNode)) {
                    if (currentChar == '\0' || currentChar > ch) {
                        currentChar = ch;
                    }
                    queue.add(ch);
                }
            }
            if (currentChar != '\0') {
                result.append(currentChar);
            } else {
                result.append(baseStr.charAt(i));
            }
        }
        return result.toString();
    }

    public String smallestEquivalentString_2ndMethod(String s1, String s2, String baseStr) { // time complexity - O(n+m)
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            int ch1 = s1.charAt(i) - 'a';
            int ch2 = s2.charAt(i) - 'a';
            union(parent, ch1, ch2);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            int parentCh = find(parent, baseStr.charAt(i) - 'a');
            result.append((char) (parentCh + 'a'));
        }
        return result.toString();
    }

    private void union(int[] parent, int a, int b) {
        int parentA = find(parent, a);
        int parentB = find(parent, b);
        if (parentA == parentB)
            return;
        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
    }

    private int find(int[] parent, int num) {
        if (parent[num] != num) {
            parent[num] = find(parent, parent[num]);
        }
        return parent[num];
    }
}
