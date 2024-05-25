package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning
 * 
 * @author subhrajeetghosh
 */
public class PalindromicSusbtringList {
    List<List<String>> result;

    public List<List<String>> partition(String s) {  //time complexity - O(n * 2^n)
        result = new ArrayList<>();
        palindromicSubString(0, s, new ArrayList<>());
        return result;
    }

    private void palindromicSubString(int index, String s, List<String> currentList) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                currentList.add(s.substring(index, i + 1));
                palindromicSubString(i + 1, s, currentList);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
