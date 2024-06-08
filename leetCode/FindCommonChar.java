package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-common-characters
 * 
 * @author subhrajeetghosh
 */
public class FindCommonChar {
    public List<String> commonChars(String[] words) { //time complexity - O(n * m)
        int[][] arr = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                arr[i][c - 'a']++;
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr[0].length; i++) {
            int minNumber = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                minNumber = Math.min(minNumber, arr[j][i]);
            }
            while (minNumber > 0) {
                result.add(String.valueOf((char) ('a' + i)));
                minNumber--;
            }
        }
        return result;
    }
}
