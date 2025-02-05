package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal
 * 
 * @author subhrajeetghosh
 */
public class OneSwapCanMakeStringEqual {
    public boolean areAlmostEqual(String s1, String s2) { // time complexity - O(n)
        if (s1.equals(s2)) {
            return true;
        }
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff.add(i);
            }
        }
        return diff.size() == 2 && s1.charAt(diff.get(0)) == s2.charAt(diff.get(1))
                && s1.charAt(diff.get(1)) == s2.charAt(diff.get(0));
    }

    public boolean areAlmostEqual_2ndMethod(String s1, String s2) { //time comlexity - O(n)
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                set1.add(s1.charAt(i));
                set2.add(s2.charAt(i));
                count++;
            }
        }
        for (Character str : set1) {
            if (!set2.contains(str))
                return false;
        }
        return count == 0 || (set1.size() == 2 && set2.size() == 2 && count == 2);
    }
}
