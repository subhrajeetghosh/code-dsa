package leetCode;

/**
 * https://leetcode.com/problems/count-good-numbers
 * 
 * @author subhrajeetghosh
 */
public class CountGoodsNumbers {
    int mod = 1000000007;

    public int countGoodNumbers(long n) { // time complexity - O(n)
        long result = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result = (result * 5) % mod;
            } else {
                result = (result * 4) % mod;
            }
        }
        return (int) result;
    }

    public int countGoodNumbers_2ndMethod(long n) { //time complexity - O(log exp)
        long evens = (n + 1) / 2;
        long odds = n / 2;
        return (int) ((powerMode(5, evens) * powerMode(4, odds)) % mod);
    }

    private long powerMode(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
}
