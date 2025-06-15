package leetCode;

/**
 * https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer
 * 
 * @author subhrajeetghosh
 */
public class MaxDiffChangeInteger { // time complexity - O(n)
    public int maxDiff(int num) {
        String s1 = String.valueOf(num);
        int changeIndex = 0;
        while (changeIndex < s1.length() && s1.charAt(changeIndex) == '9') {
            changeIndex++;
        }
        char c = '9';
        if (changeIndex < s1.length()) {
            c = s1.charAt(changeIndex);
        }
        StringBuilder sb = new StringBuilder(s1);
        for (int i = 0; i < s1.length(); i++) {
            if (sb.charAt(i) == c) {
                sb.setCharAt(i, '9');
            }
        }
        s1 = sb.toString();
        String s2 = String.valueOf(num);
        changeIndex = 0;
        char currentChange = c;
        while (changeIndex < s2.length() && (s2.charAt(changeIndex) == '1' || s2.charAt(changeIndex) == '0')) {
            changeIndex++;
        }
        if (changeIndex == 0) {
            currentChange = '1';
        } else {
            currentChange = '0';
        }
        if (changeIndex < s2.length()) {
            c = s2.charAt(changeIndex);
            sb = new StringBuilder(s2);
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == c) {
                    sb.setCharAt(i, currentChange);
                }
            }
            s2 = sb.toString();
        }
        return Integer.parseInt(s1) - Integer.parseInt(s2);
    }
}
