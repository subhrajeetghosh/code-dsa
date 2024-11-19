package leetCode;

/**
 * https://leetcode.com/problems/defuse-the-bomb
 * 
 * @author subhrajeetghosh
 */
public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) { // time complexity - O(n |k|)
        int[] result = new int[code.length];

        for (int i = 0; i < code.length; i++) {
            int sum = 0;
            if (k != 0) {
                int tempK = Math.abs(k);
                int currentIndex = (k > 0) ? i + 1 : i - 1;

                while (tempK-- > 0) {
                    if (currentIndex == code.length)
                        currentIndex = 0;
                    if (currentIndex == -1)
                        currentIndex = code.length - 1;
                    sum += code[currentIndex];
                    currentIndex += (k > 0) ? 1 : -1;
                }
            }
            result[i] = sum;
        }

        return result;
    }
}
