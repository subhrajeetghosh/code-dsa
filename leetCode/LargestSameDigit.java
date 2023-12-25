package leetCode;

/**
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string
 * 
 * @author subhrajeetghosh
 */
public class LargestSameDigit {
    public String largestGoodInteger(String num) {
        int result = -1;
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                result = Math.max(result, num.charAt(i) - '0');
            }
        }
        return result != -1 ? result + "" + result + "" + result : "";
    }

    public String largestGoodInteger_2ndMethod(String num) {
        int currentNum = -1;
        String currentString = "";
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                if (currentNum < num.charAt(i) - '0') {
                    currentNum = num.charAt(i) - '0';
                    currentString = num.substring(i, i + 3);
                }
            }
        }
        return currentString;
    }
}
