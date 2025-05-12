package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/finding-3-digit-even-numbers
 * 
 * @author subhrajeetghosh
 */
public class FindThreeDigitEvenNumbers {
    Set<Integer> result;

    public int[] findEvenNumbers(int[] digits) { // time complexity - O(n^3)
        result = new HashSet<>();
        possibleDigits(digits, 0, new HashSet<>(), new StringBuilder());
        int[] res = new int[result.size()];
        int index = 0;
        for (int num : result) {
            res[index++] = num;
        }
        Arrays.sort(res);
        return res;
    }

    private void possibleDigits(int[] digits, int index, Set<Integer> indexSet, StringBuilder sb) {
        if (indexSet.size() > 3)
            return;
        if (indexSet.size() == 3 && sb.charAt(0) != '0') {
            int currentDigit = Integer.parseInt(sb.toString());
            if (currentDigit % 2 == 0) {
                result.add(Integer.parseInt(sb.toString()));
            }
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (indexSet.add(i)) {
                int deleteIndex = sb.length();
                sb.append(digits[i]);
                possibleDigits(digits, i, indexSet, sb);
                indexSet.remove(i);
                sb.delete(deleteIndex, sb.length());
            }
        }
    }

    // optimized version
    public int[] findEvenNumbers_2ndMethod(int[] digits) { // time complexity - O(n^3)
        Arrays.sort(digits);
        Set<String> resultSet = new HashSet<>();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i != j && i != k && j != k && digits[i] != 0 && digits[k] % 2 == 0) {
                        String str = digits[i] + "" + digits[j] + "" + digits[k];
                        if (resultSet.add(str)) {
                            resultList.add(Integer.parseInt(str));
                        }
                    }
                }
            }
        }
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultList) {
            result[index++] = num;
        }
        return result;
    }

    // more optimized
    public int[] findEvenNumbers_3rdMethod(int[] digits) { // time complexity - O(n)
        int[] count = new int[10];
        List<Integer> resultList = new ArrayList<>();
        for (int digit : digits) {
            count[digit]++;
        }
        for (int i = 1; i < 10; i++) {
            if (count[i] == 0)
                continue;
            count[i]--;
            for (int j = 0; j < 10; j++) {
                if (count[j] == 0)
                    continue;
                count[j]--;
                for (int k = 0; k < 10; k += 2) {
                    if (count[k] != 0) {
                        resultList.add(i * 100 + j * 10 + k);
                    }
                }
                count[j]++;
            }
            count[i]++;
        }
        int[] resultArr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }
        return resultArr;
    }
}
