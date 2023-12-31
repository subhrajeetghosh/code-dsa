package dynamicprogrammingcourse;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * write a function countConstruct(target, wordbank) that accept target String
 * and
 * an array of String
 * the function should return the number of ways target
 * can be constructing by concatnating the elements from wordBank
 * you may reuse element of "wordBank" as many time as needed
 * 
 * 
 * @author subhrajeetghosh
 */

public class CountConstructString {
    int count = 0;

    public int countConstruct(String target, String[] wordBank) {
        // countConstruct_1stMethod(target, wordBank, "");
        countConstruct_2ndMethod(target, wordBank);
        return count;
    }

    // BruteForce Approch
    public void countConstruct_1stMethod(String target, String[] wordBank, String constructString) {
        if (target.length() <= constructString.length()) {
            if (target.equals(constructString)) {
                count++;
            }
            return;
        }
        for (String word : wordBank) {
            String newConstruct = constructString.concat(word);
            countConstruct_1stMethod(target, wordBank, newConstruct);
        }
    }

    // Memorized Approch
    Map<String, Boolean> map = new HashMap<>();

    public boolean countConstruct_2ndMethod(String target, String[] wordBank) {
        if (map.containsKey(target) && map.get(target)) {
            count++;
            return true;
        }
        if (target.isEmpty()) {
            count++;
            return true;
        }
        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.replace(word, "");
                if (countConstruct_2ndMethod(suffix, wordBank)) {
                    map.put(target, true);
                }
            }
        }
        map.put(target, false);
        return false;
    }

    // Dynamic Programming
    public int countConstruct_3rdMethod(String target, String[] wordBank) {
        int[] constructCount = new int[target.length() + 1];
        constructCount[0] = 1;
        for (int i = 0; i < target.length(); i++) {
            if (constructCount[i] > 0) {
                for (String word : wordBank) {
                    if (i + word.length() <= target.length() && target.substring(i, i + word.length()).equals(word)) {
                        constructCount[i + word.length()] += constructCount[i];
                    }
                }
            }
        }
        return constructCount[target.length()];
    }

    public static void main(String[] args) {
        String[] arr = { "abc", "dasa", "def", "ab", "c", "d", "ef", "e", "f" };
        System.out.println(new CountConstructString().countConstruct("abcdef", arr));
        System.out.println(new CountConstructString().countConstruct_3rdMethod("abcdef", arr));
    }
}
