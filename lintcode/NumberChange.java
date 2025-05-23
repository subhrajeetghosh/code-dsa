package lintcode;

/**
 * https://www.lintcode.com/problem/1825
 * 
 * @author subhrajeetghosh
 */
public class NumberChange {
    public int numberChange(int k) { // time complexity - O(log k)
        int count = 0;
        while (k > 0) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k--;
            }
            count++;
        }
        return count;
    }
}
