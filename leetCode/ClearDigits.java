package leetCode;

/**
 * https://leetcode.com/problems/clear-digits
 * 
 * @author subhrajeetghosh
 */
public class ClearDigits {
    public String clearDigits(String s) { // time complexity - O(n * d)
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            boolean isFound = false;
            for (int i = 0; i < sb.length(); i++) {
                if (Character.isDigit(sb.charAt(i))) {
                    isFound = true;
                    sb.deleteCharAt(i - 1);
                    sb.deleteCharAt(i - 1);
                    break;
                }
            }
            if (!isFound)
                break;
        }
        return sb.toString();
    }
}
