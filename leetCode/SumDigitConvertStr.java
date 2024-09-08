package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-of-digits-of-string-after-convert
 * 
 * @author subhrajeetghosh
 */

public class SumDigitConvertStr {
    public int getLucky_2ndMethod(String s, int k) { //time complexity - O(n k(m * log(sum)))
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int currentVal = (s.charAt(i) - 'a') + 1;
            if (currentVal > 9) {
                list.add(currentVal / 10);
            }
            list.add(currentVal % 10);
        }
        int result = 0;
        while (k-- > 0) {
            int currentTotal = 0;
            for (int i : list) {
                currentTotal += i;
            }
            result = currentTotal;
            list.clear();
            while (currentTotal > 0) {
                list.add(currentTotal % 10);
                currentTotal /= 10;
            }
        }
        return result;
    }

    //optimized approch
    public int getLucky(String s, int k) {  //time complexity - O(n k-1(log(result)))
        int result = 0;
        for(char c : s.toCharArray()) {
            int currentValue = c - 'a' + 1;
            result += currentValue / 10 + currentValue % 10;
        }

        while(--k > 0) {
            int sum = 0;
            while(result > 0) {
                sum += result % 10;
                result /= 10;
            }
            result = sum;
        }
        return result;
    }
}
