package leetCode;

/**
 * https://leetcode.com/problems/custom-sort-string/
 * 
 * @author subhrajeetghosh
 */
public class CustomSortString {
    public String customSortString(String order, String s) { // time complexity - O(n + m)
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];
        int[] sArr = new int[26];
        for (char c : s.toCharArray()) {
            sArr[c - 'a']++;
        }
        for (char c : order.toCharArray()) {
            while (sArr[c - 'a'] > 0) {
                sb.append(c);
                arr[c - 'a']++;
                sArr[c - 'a']--;
            }

        }
        for (char c : s.toCharArray()) {
            if (arr[c - 'a'] > 0) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
