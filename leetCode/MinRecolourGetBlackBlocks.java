package leetCode;

/**
 * https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks
 * 
 * @author subhrajeetghosh
 */
public class MinRecolourGetBlackBlocks {
    public int minimumRecolors(String blocks, int k) { // time complexity - O(n)
        int windowWhite = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                windowWhite++;
            }
        }
        int minOperation = windowWhite;
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W')
                windowWhite++;
            if (blocks.charAt(i - k) == 'W')
                windowWhite--;
            minOperation = Math.min(minOperation, windowWhite);
        }
        return minOperation;
    }
}
