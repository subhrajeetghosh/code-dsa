package tree;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/bag-of-tokens/
 * 
 * @author subhrajeetghosh
 */
public class BagofTokens {
    public int bagOfTokensScore(int[] tokens, int power) { // time complexity - O(n)
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1;
        int resultCount = 0;
        int result = 0;
        while (i <= j) {
            if (power >= tokens[i]) {
                resultCount++;
                power -= tokens[i++];
            } else if (resultCount > 0) {
                resultCount--;
                power += tokens[j--];
            } else {
                break;
            }
            result = Math.max(result, resultCount);
        }
        return result;
    }
}
