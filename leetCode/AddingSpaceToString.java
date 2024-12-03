package leetCode;

/**
 * https://leetcode.com/problems/adding-spaces-to-a-string
 * 
 * @author subhrajeetghosh
 */
public class AddingSpaceToString {
    public String addSpaces(String s, int[] spaces) { // time complexity - O(n)
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (index < spaces.length && spaces[index] == i) {
                sb.append(' ');
                index++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
