package leetCode;

/**
 * https://leetcode.com/problems/count-total-number-of-colored-cells
 * 
 * @author subhrajeetghosh
 */
public class CountTotalNumberColourCell {
    public long coloredCells(int n) { // time complexity - O(n)
        long result = 1l;
        int count = 1;
        while (n - 1 > 0) {
            result += count * 4;
            count++;
            n--;
        }
        return result;
    }
}
