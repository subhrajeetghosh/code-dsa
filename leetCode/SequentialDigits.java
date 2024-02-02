package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/sequential-digits
 * 
 * @author subhrajeetghosh
 */

class SequentialDigits {
    // Bruteforce approch
    public List<Integer> sequentialDigits_2ndMethod(int low, int high) { // time complexity - O(high-low) * log(high)
        List<Integer> ans = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            StringBuilder sb = new StringBuilder().append(i);
            int j = 0;
            while (j < sb.length() - 1) {
                if (sb.charAt(j) - '0' != (sb.charAt(j + 1) - '0') - 1) {
                    break;
                }
                j++;
            }
            if (j == sb.length() - 1)
                ans.add(i);
        }
        return ans;
    }

    //Recursive approch optimized
    List<Integer> result;
    String digit = "123456789";

    public List<Integer> sequentialDigits(int low, int high) {
        result = new ArrayList<>();
        validCount(0, low, high);
        Collections.sort(result);
        return result;
    }

    public void validCount(int index, int low, int high) {
        if (index >= digit.length())
            return;
        for (int i = index + 1; i < digit.length(); i++) {
            int current = Integer.parseInt(digit.substring(index, i + 1));
            if (validDigitChecker(current, low, high)) {
                result.add(current);
            }
        }
        validCount(index + 1, low, high);
    }

    private boolean validDigitChecker(int currentDigit, int low, int high) {
        return currentDigit >= low && currentDigit <= high;
    }
}