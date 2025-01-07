package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/string-matching-in-an-array
 * 
 * @author subhrajeetghosh
 */
public class StringMatchingInArray {
    public List<String> stringMatching(String[] words) { // time complexity - O(n * n * m)
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].indexOf(words[i]) != -1) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
    //Another Approch
    public List<String> stringMatching_2ndMethod(String[] words) { //time complexity - O(n log n + n^2 m)
        List<String> result = new ArrayList<String>();
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        for(int i=0; i<words.length; i++) {
            for(int j=i+1; j<words.length; j++) {
                if(words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}
