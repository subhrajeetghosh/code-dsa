package leetCode;

/**
 * https://leetcode.com/problems/push-dominoes
 * 
 * @author subhrajeetghosh
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) { //time complexity - O(n)
        int right = -1;
        StringBuilder sb = new StringBuilder(dominoes);
        for (int i = 0; i < dominoes.length(); i++) {
            char currentChar = dominoes.charAt(i);
            if (currentChar == 'L' && right != -1) {
                int leftIndex = right + 1, rightIndex = i - 1;
                while (leftIndex < rightIndex) {
                    sb.setCharAt(leftIndex++, 'R');
                    sb.setCharAt(rightIndex--, 'L');
                }
                right = -1;
            } else if (currentChar == 'R' && right != -1) {
                int currentIndex = right + 1;
                while (currentIndex < i) {
                    sb.setCharAt(currentIndex++, 'R');
                }
                right = i;
            } else if (currentChar == 'L' && right == -1) {
                int currentIndex = i - 1;
                while (currentIndex >= 0 && sb.charAt(currentIndex) == '.') {
                    sb.setCharAt(currentIndex--, 'L');
                }
            } else if (currentChar == 'R' && right == -1) {
                right = i;
            }
        }
        if (right != -1) {
            int currentIndex = right + 1;
            while (currentIndex < dominoes.length()) {
                sb.setCharAt(currentIndex++, 'R');
            }
        }
        return sb.toString();
    }
}
