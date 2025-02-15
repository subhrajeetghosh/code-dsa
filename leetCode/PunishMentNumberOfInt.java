package leetCode;

/**
 * https://leetcode.com/problems/find-the-punishment-number-of-an-integer/
 * 
 * @author subhrajeetghosh
 */
public class PunishMentNumberOfInt {
    public int punishmentNumber(int n) { // time complexity - O(n * 9^d)
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (getDigitSum(String.valueOf(i * i), 0, i, 0)) {
                result += i * i;
            }
        }
        return result;
    }

    private boolean getDigitSum(String n, int index, int target, int sum) {
        if (index == n.length()) {
            return sum == target;
        }
        for (int i = index; i < n.length(); i++) {
            int currentSum = Integer.parseInt(n.substring(index, i + 1));
            if (getDigitSum(n, i + 1, target, currentSum + sum)) {
                return true;
            }
        }
        return false;
    }
}
