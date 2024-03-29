package leetCode;

/**
 * https://leetcode.com/problems/number-of-laser-beams-in-a-bank
 * 
 * @author subhrajeetghosh
 */
public class LaserBeamInBank {
    public int numberOfBeams(String[] bank) { // time complexity - O(m*n)
        int prevCount = 0;
        int index = 0;
        int result = 0;
        while (prevCount == 0 && index < bank.length) {
            char[] chrArray = bank[index].toCharArray();
            for (int i = 0; i < chrArray.length; i++) {
                if (chrArray[i] == '1')
                    prevCount++;
            }
            index++;
        }
        for (; index < bank.length; index++) {
            int currentCount = 0;
            char[] chrArray = bank[index].toCharArray();
            for (int i = 0; i < chrArray.length; i++) {
                if (chrArray[i] == '1')
                    currentCount++;
            }
            if (currentCount > 0) {
                result += prevCount * currentCount;
                prevCount = currentCount;
                currentCount = 0;
            }
        }
        return result;
    }

    public int numberOfBeams_2ndMethod(String[] bank) { // different approch
        int total = 0;
        int prev = 0;
        for (String str : bank) {
            int level = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    total += prev;
                    level++;
                }
            }
            if (level > 0) {
                prev = level;
            }
        }
        return total;
    }
}
