package leetCode;

/**
 * https://leetcode.com/problems/divisible-and-non-divisible-sums-difference
 * 
 * @author subhrajeetghosh
 */
public class DivAndNonDivSumDiff {
    public int differenceOfSums(int n, int m) { // time complexity - O(n)
        int sumDivM = 0, sumNonDivM = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                sumDivM += i;
            } else {
                sumNonDivM += i;
            }
        }
        return sumNonDivM - sumDivM;
    }

    public int differenceOfSums_2ndMethod(int n, int m) { // time complexity - O(1)
        return ((n * (n + 1)) / 2) - 2 * (((n / m) * ((n / m) + 1) / 2) * m);
    }
}
