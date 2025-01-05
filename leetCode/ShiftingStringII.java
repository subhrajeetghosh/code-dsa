package leetCode;

/**
 * https://leetcode.com/problems/shifting-letters-ii
 * 
 * @author subhrajeetghosh
 */
public class ShiftingStringII {
    public String shiftingLetters_2ndMethod(String s, int[][] shifts) { // time complexity - O(n * q)
        int[] strArr = new int[s.length()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = s.charAt(i) - 'a';
        }
        for (int[] shift : shifts) {
            if (shift[2] == 0) {
                for (int i = shift[0]; i <= shift[1]; i++) {
                    strArr[i] = strArr[i] - 1;
                    if (strArr[i] == -1) {
                        strArr[i] = 25;
                    }
                }
            } else {
                for (int i = shift[0]; i <= shift[1]; i++) {
                    strArr[i] = strArr[i] + 1;
                    if (strArr[i] == 26) {
                        strArr[i] = 0;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append((char) (strArr[i] + 'a'));
        }
        return sb.toString();
    }

    // Optimized approch
    public String shiftingLetters(String s, int[][] shifts) { // time complexity - O(n + q)
        int[] count = new int[s.length() + 1];
        for (int[] shift : shifts) {
            int value = shift[2] == 0 ? -1 : 1;
            count[shift[0]] += value;
            count[shift[1] + 1] -= value;
        }
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length - 1; i++) {
            sum += count[i];
            int currentChar = (((sum + (s.charAt(i) - 'a')) % 26) + 26) % 26;
            sb.append((char) (currentChar + 'a'));
        }
        return sb.toString();
    }
}
