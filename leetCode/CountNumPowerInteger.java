package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-the-number-of-powerful-integers
 * 
 * @author subhrajeetghosh
 */
class CountNumPowerInteger {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) { // time complexity - O(n * limit)
        String lowerRange = String.valueOf(start - 1);
        String upperRange = String.valueOf(finish);
        return countNumbers(upperRange, limit, s) - countNumbers(lowerRange, limit, s);
    }

    private long countNumbers(String numStr, int limit, String suffix) {
        if (numStr.length() < suffix.length()) {
            return 1;
        }
        Long[][] memo = new Long[numStr.length()][2];
        for (Long[] row : memo) {
            Arrays.fill(row, -1);
        }
        return digitDp(numStr, 0, 1, suffix, limit, memo);
    }

    private long digitDp(String upperRangeStr, int position, int tight, String suffix, int maxDigit, Long[][] memo) {
        if (position == upperRangeStr.length() - suffix.length()) {
            if (tight == 0)
                return 1;
            String subRange = upperRangeStr.substring(position);
            return suffix.compareTo(subRange) > 0 ? 0 : 1;
        }
        if (memo[position][tight] != -1)
            return memo[position][tight];
        int upperBound = (tight == 1) ? Math.min(maxDigit, upperRangeStr.charAt(position) - '0') : maxDigit;
        Long count = 0l;
        for (int i = 0; i <= upperBound; i++) {
            int nextTight = (tight == 1 && upperRangeStr.charAt(position) - '0' == i) ? 1 : 0;
            count += digitDp(upperRangeStr, position + 1, nextTight, suffix, maxDigit, memo);
        }
        return memo[position][tight] = count;
    }
}