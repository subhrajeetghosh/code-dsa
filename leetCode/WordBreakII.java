package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-break-ii
 * 
 * @author subhrajeetghosh
 */
public class WordBreakII {
    List<String> result;

    public List<String> wordBreak_2ndMethod(String s, List<String> wordDict) { // time complexity - O(n* 2^n),
        // n - s.length
        result = new ArrayList<>();
        dfs_2ndMethod(s, 0, wordDict, new StringBuilder());
        return result;
    }

    private void dfs_2ndMethod(String s, int strIndex, List<String> wordDict, StringBuilder currString) {
        if (s.length() <= strIndex) {
            result.add(currString.toString());
            return;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            if (s.indexOf(wordDict.get(i), strIndex) == strIndex) {
                currString = currString.length() == 0 ? currString : currString.append(" ");
                currString.append(wordDict.get(i));
                dfs_2ndMethod(s, strIndex + wordDict.get(i).length(), wordDict, currString);
                currString.delete(currString.length() - wordDict.get(i).length(), currString.length());
                if (!currString.isEmpty())
                    currString.deleteCharAt(currString.length() - 1);
            }
        }
    }

    // memoriztion approch
    Map<Integer, List<String>> memo;

    public List<String> wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        return dfs(s, 0, wordDict);
    }

    private List<String> dfs(String s, int index, List<String> wordDict) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        List<String> result = new ArrayList<>();
        if (s.length() <= index) {
            result.add("");
            return result;
        }

        for (String word : wordDict) {
            if (s.startsWith(word, index)) {
                List<String> subList = dfs(s, index + word.length(), wordDict);
                for (String str : subList) {
                    result.add(word + (str.isEmpty() ? "" : " ") + str);
                }
            }
        }
        memo.put(index, result);
        return result;
    }

    public static void main(String[] args) {
        List<String> arr = Arrays.asList("x", "xx", "xxx");
        new WordBreakII().wordBreak("xxx", arr);
    }
}
