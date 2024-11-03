package leetCode;

/**
 * https://leetcode.com/problems/rotate-string
 * 
 * @author subhrajeetghosh
 */
public class RotateString {
    public boolean rotateString(String s, String goal) { // time complexity - O(n)
        return s.length() == goal.length() && (goal + goal).contains(s);
    }
}
