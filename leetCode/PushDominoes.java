package leetCode;

/**
 * https://leetcode.com/problems/push-dominoes
 * 
 * @author subhrajeetghosh
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) { // time complexity - O(n)
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

    public String pushDominoes_2ndMethod(String dominoes) { //time complexity - O(n)
        int n = dominoes.length();
        int[] netForce = new int[n];
        int rightForce = 0;
        char[] charArray = dominoes.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (charArray[i] == 'R') {
                rightForce = n;
            } else if (charArray[i] == 'L') {
                rightForce = 0;
            } else {
                rightForce--;
            }
            netForce[i] = Math.max(0, rightForce);
        }
        int leftForce = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (charArray[i] == 'R') {
                leftForce = 0;
            } else if (charArray[i] == 'L') {
                leftForce = n;
            } else {
                leftForce--;
            }
            netForce[i] -= Math.max(0, leftForce);
        }
        for (int i = 0; i < n; i++) {
            sb.append(netForce[i] > 0 ? 'R' : netForce[i] < 0 ? 'L' : '.');
        }
        return sb.toString();
    }
}
