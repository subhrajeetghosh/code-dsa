
/**
 * https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary
 * 
 * @author subhrajeetghosh
 */

public class NumberWaysTargetForm {
    int count = 0;

    public int numWays(String[] words, String target) {
        canConstructNumWays(words, target, 0);
        return count;
    }

    //Bruteforce approch
    public void canConstructNumWays(String[] words, String target, int j) {
        if (target.isEmpty()) {
            count++;
            return;
        }
        for (String word : words) {
            for (int i = j; i < word.length(); i++) {
                if (target.indexOf(word.charAt(i)) == 0) {
                    String suffix = target.substring(1);
                    canConstructNumWays(words, suffix, i + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = { "accc", "bbbb" };
        System.out.println(new NumberWaysTargetForm().numWays(arr, "ab"));
    }
}
