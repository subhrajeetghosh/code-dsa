package leetCode;

/**
 * https://leetcode.com/problems/power-of-two
 * 
 * @author subhrajeetghosh
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) { // time complexity - O(log n)
        if (n < 1)
            return false;
        if (n == 1)
            return true;
        if (n % 2 != 0)
            return false;
        return isPowerOfTwo(n / 2);
    }

    public boolean isPowerOfTwo_2ndMethod(int n) { // time complexity - O(log n)
        if (n < 1)
            return false;
        if (n == 1)
            return true;
        int num = 1;
        while (num < n) {
            num *= 2;
        }
        return num == n;
    }
}
