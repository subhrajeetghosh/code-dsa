package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts
 * 
 * @author subhrajeetghosh
 */
public class LongestSubsEvenCounts {
    public int findTheLongestSubstring(String s) { // time complexity - O(n)
        Map<String, Integer> map = new HashMap<>();
        map.put("00000", -1);
        int[] charMap = new int[5];
        int index = 0;
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                charMap[0] = (charMap[0] + 1) % 2;
            } else if (c == 'e') {
                charMap[1] = (charMap[1] + 1) % 2;
            } else if (c == 'i') {
                charMap[2] = (charMap[2] + 1) % 2;
            } else if (c == 'o') {
                charMap[3] = (charMap[3] + 1) % 2;
            } else if (c == 'u') {
                charMap[4] = (charMap[4] + 1) % 2;
            }

            String sb = createBuilderString(charMap);
            if (map.containsKey(sb)) {
                result = Math.max(result, index - map.get(sb));
            } else {
                map.put(sb, index);
            }
            index++;
        }
        return result;
    }

    private String createBuilderString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new LongestSubsEvenCounts().findTheLongestSubstring("bc");
    }
}
