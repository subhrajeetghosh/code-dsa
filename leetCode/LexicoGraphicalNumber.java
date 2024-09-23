package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lexicographical-numbers
 * 
 * @author subhrajeetghosh
 */
public class LexicoGraphicalNumber {
    List<Integer> result = new ArrayList<>();
    int maxNum;

    public List<Integer> lexicalOrder(int n) { // time complexity - O(n)
        maxNum = n;
        for (int i = 1; i <= 9; i++) {
            dfs(i);
        }
        return result;
    }

    private void dfs(int number) {
        if (maxNum < number) {
            return;
        }
        result.add(number);
        for (int i = 0; i <= 9; i++) {
            dfs(number * 10 + i);
        }
    }
}
