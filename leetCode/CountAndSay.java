package leetCode;
/*
 * https://leetcode.com/problems/count-and-say/
 * 
 * @author subhrajeetghosh
 */

public class CountAndSay {
    public String countAndSay(int n) {
        String currentNumberString = "1";
        for (int i = 1; i < n; i++) {
            int countSameNum = 1;
            StringBuilder newFormString = new StringBuilder();
            int currentNumber = currentNumberString.charAt(0) - '0';
            for (int j = 1; j < currentNumberString.length(); j++) {
                if (currentNumberString.charAt(j) - '0' == currentNumber) {
                    countSameNum++;
                } else {
                    newFormString.append(countSameNum + "" + currentNumber);
                    currentNumber = currentNumberString.charAt(j) - '0';
                    countSameNum = 1;
                }
            }
            newFormString.append(countSameNum + "" + currentNumber);
            currentNumberString = newFormString.toString();
        }
        return currentNumberString;
    }

    public static void main(String[] args) {
        CountAndSay obj = new CountAndSay();
        System.out.println(obj.countAndSay(4));
    }
}