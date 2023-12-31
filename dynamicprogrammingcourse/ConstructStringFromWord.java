package dynamicprogrammingcourse;

import java.util.HashMap;
import java.util.Map;

/**
 * write a function canConstruct(target, wordbank) that accept target String and
 * an array of String
 * the function should return a boolean indicating wheather or not the target
 * can be constructing by concatnating the elements from wordBank
 * you may reuse element of "wordBank" as many time as needed
 * 
 * @author subhrajeetghosh
 */

public class ConstructStringFromWord {
    Map<String, Boolean> map = new HashMap<String, Boolean>();

    public boolean canConstruct(String target, String[] wordBank) {
        // return checkCanConstruct(new StringBuilder(), target, wordBank, 0);
        return checkCanConstruct_2ndMethod(target, wordBank, new StringBuilder());
    }

    // Recursion
    public boolean checkCanConstruct(StringBuilder sb, String target, String[] wordBank, int index) {
        if (target.length() < sb.length() || index >= wordBank.length)
            return false;
        else if (target.equals(sb.toString())) {
            return true;
        }
        return checkCanConstruct(new StringBuilder(sb).append(wordBank[index]), target, wordBank, index) ||
                checkCanConstruct(new StringBuilder(sb).append(wordBank[index]), target, wordBank, index + 1)
                || checkCanConstruct(sb, target, wordBank, index + 1);
    }

    // Recursion with Backtracking loop
    public boolean checkCanConstruct_2ndMethod(String target, String[] wordBank, StringBuilder sb) {
        if (target.length() < sb.length())
            return false;
        else if (target.equals(sb.toString())) {
            return true;
        }
        for (String word : wordBank) {
            StringBuilder currentString = new StringBuilder(sb).append(word);
            boolean isTrueThisCombo = checkCanConstruct_2ndMethod(target, wordBank, currentString);
            if (isTrueThisCombo)
                return true;
        }
        return false;
    }

    // Another way of Solutioning
    public boolean checkCanConstruct_3rdMethod(String target, String[] wordBank) {
        if (target.isEmpty()) {
            return true;
        }
        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.replace(word, "");
                if (checkCanConstruct_3rdMethod(suffix, wordBank)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Memorization
    public boolean checkCanConstruct_4thMethod(String target, String[] wordBank) {
        if (map.containsKey(target))
            return map.get(target);
        if (target.isEmpty()) {
            return true;
        }
        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.replace(word, "");
                if (checkCanConstruct_4thMethod(suffix, wordBank)) {
                    map.put(target, true);
                    return true;
                }
            }
        }
        map.put(target, false);
        return false;
    }

    // Dynamic Programming
    public boolean checkCanConstruct_5thMethod(String target, String[] wordBank) { // time complexity = O(m^2n) and
                                                                                   // space = O(m)
        boolean[] matcher = new boolean[target.length() + 1];
        matcher[0] = true;
        for (int i = 0; i < target.length(); i++) {
            if (matcher[i]) {
                for (String word : wordBank) {
                    if (i + word.length() <= target.length() && target.substring(i, i + word.length()).equals(word)) {
                        matcher[i + word.length()] = true;
                    }
                }
            }
        }
        return matcher[target.length()];
    }

    public static void main(String[] args) {
        String[] arr = { "abc", "dasa", "def" };
        System.out.println(new ConstructStringFromWord().canConstruct("abcdef", arr));
        System.out.println(new ConstructStringFromWord().checkCanConstruct_5thMethod("abcdef", arr));
    }
}
