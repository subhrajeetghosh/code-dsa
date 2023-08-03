import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary
 * 
 * @author subhrajeetghosh
 */

public class NumberWaysTargetForm {
    int count = 0;
    static final int MODULO = 1000000007;
    Map<String, Integer> memo = new HashMap<>();

    public int numWays(String[] words, String target) {
        memo.clear();
        return countConstruct_2ndMethod(words, target, 0);
    }

    // Bruteforce approch
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

    // BruteForce approch with return variable
    public int countConstruct_2ndMethod(String[] words, String target, int j) {
        if (target.isEmpty()) {
            return 1;
        }
        int currentCount = 0;
        for (String word : words) {
            for (int i = j; i < word.length(); i++) {
                if (target.indexOf(word.charAt(i)) == 0) {
                    String suffix = target.substring(1);
                    currentCount += countConstruct_2ndMethod(words, suffix, i + 1);
                }
            }
        }
        return currentCount % MODULO;
    }

    // Memorize approch of the 2nd_Method
    public int countConstruct_3rdMethod(String[] words, String target, int j) {
        if (target.isEmpty()) {
            return 1;
        }
        String memoKey = j + "_" + target;
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }
        int currentCount = 0;
        for (String word : words) {
            for (int i = j; i < word.length(); i++) {
                if (target.indexOf(word.charAt(i)) == 0) {
                    String suffix = target.substring(1);
                    currentCount += countConstruct_3rdMethod(words, suffix, i + 1);
                    currentCount %= MODULO;
                }
            }
        }
        memo.put(memoKey, currentCount);
        return currentCount;
    }

    public static void main(String[] args) {
        String[] arr = { "accc", "bbbb" };
        System.out.println(new NumberWaysTargetForm().numWays(arr, "ab"));
    }
}
