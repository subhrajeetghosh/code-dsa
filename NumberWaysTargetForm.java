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

    int[][] charArray;
    int charLength = 0;
    int targetLength = 0;
    String targetStr = "";
    Integer[][] dpMemoriz;

    public int numWays_1(String[] words, String target) {
        charLength = words[0].length();
        charArray = new int[26][charLength];
        targetStr = target;
        targetLength = target.length();
        dpMemoriz = new Integer[charLength][targetLength];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                charArray[word.charAt(i) - 'a'][i]++;
            }
        }
        return canConstruct_2ndMethod(0, 0);
    }

    

    public int canConstruct(int charIndex, int targetIndex) { // time complexity O(m*n)
        if (targetIndex >= targetLength) {
            return 1;
        }
        if (charIndex >= charLength) {
            return 0;
        }
        long count = canConstruct(charIndex + 1, targetIndex);
        if (charArray[targetStr.charAt(targetIndex) - 'a'][charIndex] > 0) {
            count += (long) charArray[targetStr.charAt(targetIndex) - 'a'][charIndex]
                    * canConstruct(charIndex + 1, targetIndex + 1);
            count %= MODULO;
        }
        return (int) count;
    }

    // Dp Memorization approch
    public int canConstruct_2ndMethod(int charIndex, int targetIndex) {  //time complexity - O(m*n)
        if (targetIndex >= targetLength) {
            return 1;
        }
        if (charIndex >= charLength) {
            return 0;
        }
        char currentChar = targetStr.charAt(targetIndex);
        if (dpMemoriz[charIndex][targetIndex] > 0)
            return dpMemoriz[charIndex][targetIndex];
        long count = canConstruct_2ndMethod(charIndex + 1, targetIndex);
        if (charArray[currentChar - 'a'][charIndex] > 0) {
            count += (long) charArray[currentChar - 'a'][charIndex]
                    * canConstruct_2ndMethod(charIndex + 1, targetIndex + 1);
            count %= MODULO;
        }
        return dpMemoriz[charIndex][targetIndex] = (int) count;
    }

    public static void main(String[] args) {
        String[] arr = { "accc", "bbbb" };
        System.out.println(new NumberWaysTargetForm().numWays_1(arr, "ab"));
    }
}
