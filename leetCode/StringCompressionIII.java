package leetCode;

/**
 * https://leetcode.com/problems/string-compression-iii
 * 
 * @author subhrajeetghosh
 */
public class StringCompressionIII {
    public String compressedString(String word) { // time complexity - O(n)
        StringBuilder sb = new StringBuilder();
        char currentChar = word.charAt(0);
        int currentLen = 1;
        for (int i = 1; i < word.length(); i++) {
            if (currentChar == word.charAt(i) && currentLen < 9) {
                currentLen++;
            } else {
                sb.append(currentLen).append(currentChar);
                currentChar = word.charAt(i);
                currentLen = 1;
            }
        }
        sb.append(currentLen).append(currentChar);
        return sb.toString();
    }
}
