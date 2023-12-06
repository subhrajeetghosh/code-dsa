package leetCode;

/**
 * https://leetcode.com/problems/calculate-money-in-leetcode-bank
 * 
 * @author Subhrajeet Ghosh
 */
public class LeetCodeMoneyBank {
    public int totalMoney(int n) { // time complexity : O(n)
        int range = n / 7;
        int ans = 0;
        for (int i = 1; i <= range; i++) {
            ans += additionOfRange(i);
        }
        int leftOver = n % 7;
        while (leftOver > 0) {
            ans += ++range;
            leftOver--;
        }
        return (int) ans;
    }

    private int additionOfRange(int start) {
        int sum = 0;
        for (int i = start; i < start + 7; i++) {
            sum += i;
        }
        return sum;
    }

    public int totalMoney_2ndMethod(int n) {
        int noOfWeeks = n / 7;
        int totalMoneyForWeeks = (noOfWeeks * (28 + (28 + (noOfWeeks - 1) * 7))) / 2;
        int monday = noOfWeeks + 1;
        for (int i = 0; i < n % 7; i++) {
            totalMoneyForWeeks += monday + i;
        }
        return totalMoneyForWeeks;
    }

    public static void main(String[] args) {
        System.err.println(new LeetCodeMoneyBank().totalMoney_2ndMethod(20));
    }
}
