package leetCode;

/**
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 * 
 * @author Subhrajeet Ghosh
 */
public class MinChangeBineryStr {

    public int minOperations(String s) { // time complexity = O(n)
        int count1 = 0;
        int count2 = 1;
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        for (int i = 1; i < len; i++) {
            if (charArray[i] == charArray[i - 1]) {
                count1++;
                charArray[i] = charArray[i] == '0' ? '1' : '0';
            }
        }
        charArray = s.toCharArray();
        charArray[0] = charArray[0] == '0' ? '1' : '0';
        for (int i = 1; i < len; i++) {
            if (charArray[i] == charArray[i - 1]) {
                count2++;
                charArray[i] = charArray[i] == '0' ? '1' : '0';
            }
        }
        return Math.min(count2, count1);
    }
}
