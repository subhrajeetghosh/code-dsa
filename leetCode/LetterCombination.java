package leetCode;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number
 * 
 * @author subhrajeetghosh
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {
    Map<Integer, String> numberMap = new HashMap<>();
    List<String> listOfData = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        numberMap.put(2, "abc");
        numberMap.put(3, "def");
        numberMap.put(4, "ghi");
        numberMap.put(5, "jkl");
        numberMap.put(6, "mno");
        numberMap.put(7, "pqrs");
        numberMap.put(8, "tuv");
        numberMap.put(9, "wxyz");

        getAllCombination(digits, "", 0);
        return listOfData;
    }

    // Recursive Approch
    public void getAllCombination(String digits, String constuctCombination, int index) {
        if (constuctCombination.length() == digits.length()) {
            listOfData.add(constuctCombination);
            return;
        }
        int currentNum = digits.charAt(index) - 48;
        String currentDigitGrp = numberMap.get(currentNum);
        for (char ch : currentDigitGrp.toCharArray()) {
            String currentCombination = constuctCombination + ch;
            getAllCombination(digits, currentCombination, index + 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new LetterCombination().letterCombinations("23");
        for (String string : list) {
            System.out.println(string);
        }
    }
}
