package leetCode;

/**
 * https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i
 * 
 * @author subhrajeetghosh
 */
public class LexicographicallyLargestString {
    public String answerString(String word, int numFriends) { // time complexity - O(n^2)
        if (numFriends == 1) {
            return word;
        }
        String currentString = "";
        for (int i = 0; i < word.length(); i++) {
            currentString = lexicoLargest(currentString,
                    word.substring(i, Math.min(word.length() - numFriends + 1 + i, word.length())));
        }
        return currentString;
    }

    private String lexicoLargest(String s1, String s2) {
        if (s1.equals(s2))
            return s2;
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return s1;
            } else if (s1.charAt(i) < s2.charAt(i)) {
                return s2;
            }
        }
        if (s1.length() < s2.length()) {
            return s2;
        } else {
            return s1;
        }
    }

    public String answerString_2ndMethod(String word, int numFriends) { // time complexity - O(n^2)
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        String result = "";
        for (int i = 0; i < n; i++) {
            String currentString = word.substring(i, Math.min(n - numFriends + 1 + i, n));
            if (result.compareTo(currentString) < 0) {
                result = currentString;
            }
        }
        return result;
    }

    public String answerString_3rdMethod(String word, int numFriends) { // time complexity - O(n)
        if (numFriends == 1) {
            return word;
        }
        String largestSuffix = largestSuffix(word);
        return largestSuffix.substring(0, Math.min(word.length() - numFriends + 1, largestSuffix.length()));
    }

    private String largestSuffix(String word) {
        int bestMatch = 0, currentMatch = 1, n = word.length();
        while (currentMatch < n) {
            int maxCommon = 0;
            while (currentMatch + maxCommon < n
                    && word.charAt(bestMatch + maxCommon) == word.charAt(currentMatch + maxCommon)) {
                maxCommon++;
            }
            if (currentMatch + maxCommon < n
                    && word.charAt(bestMatch + maxCommon) < word.charAt(currentMatch + maxCommon)) {
                int oldBest = bestMatch;
                bestMatch = currentMatch;
                currentMatch = Math.max(currentMatch + 1, oldBest + maxCommon + 1);
            } else {
                currentMatch = currentMatch + maxCommon + 1;
            }
        }
        return word.substring(bestMatch);
    }
}
