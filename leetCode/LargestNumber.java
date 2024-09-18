package leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/largest-number
 * 
 * @author subhrajeetghosh
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        Comparator<String> cmp = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str2.compareTo(str1);
            }
        };
        Arrays.sort(strArr, cmp);
        if (strArr[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }
}
