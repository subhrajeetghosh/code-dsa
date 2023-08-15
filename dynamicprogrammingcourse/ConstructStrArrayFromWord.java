package dynamicprogrammingcourse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * write a function canConstruct(target, wordbank) that accept target String and
 * an array of String
 * the function should return a {@link List<List<String>>} where it should send
 * all the combination
 * can be constructing by concatnating the elements from wordBank
 * you may reuse element of "wordBank" as many time as needed
 * 
 * @author Subhrajeet Ghosh
 */

public class ConstructStrArrayFromWord {
    List<List<String>> constructedStringsList = new ArrayList<>();

    public List<List<String>> constructArrayOfStirngFromWords(String target, String[] wordBank) {
        constructString_1stMethod(target, wordBank, new ArrayList<>());
        return constructedStringsList;
    }

    // Recursive method
    public void constructString_1stMethod(String target, String[] wordBank, List<String> currentStringBank) {
        if (target.isEmpty()) {
            constructedStringsList.add(new ArrayList<>(currentStringBank));
            return;
        }
        // Backtracking
        for (int i = 0; i < wordBank.length; i++) {
            if (target.indexOf(wordBank[i]) == 0) {
                String currentString = target.substring(wordBank[i].length());
                currentStringBank.add(wordBank[i]);
                constructString_1stMethod(currentString, wordBank, currentStringBank);
                currentStringBank.remove(currentStringBank.size() - 1);
            }
        }
    }

    //Memorization
    Map<String, List<List<String>>> map = new HashMap<>();
    public List<List<String>> constructString_2ndMethod(String target, String[] wordBank) {
        if(map.containsKey(target)) {
            return map.get(target);
        }
        if (target.isEmpty()) {
            List<List<String>> resultList = new ArrayList<>();
            resultList.add(new ArrayList<>());
            return resultList;
        }
        // Backtracking
        List<List<String>> result = new ArrayList<>();
        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                List<List<String>> resultantString = constructString_2ndMethod(target.substring(
                        word.length()), wordBank);
                for (List<String> stringList : resultantString) {
                    List<String> targetList = new ArrayList<>(stringList);
                    targetList.add(0, word);
                    result.add(targetList);
                }
            }
        }
        map.put(target, result);
        return result;
    }



    public static void main(String[] args) {
        List<List<String>> stringArrays = new ConstructStrArrayFromWord().constructString_2ndMethod(
                "abcdef", new String[] { "ab", "abc", "def", "cd", "abcd", "ef", "c" });
        for (List<String> list : stringArrays) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
