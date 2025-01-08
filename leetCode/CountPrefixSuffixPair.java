package leetCode;

/**
 * https://leetcode.com/problems/count-prefix-and-suffix-pairs-i
 * 
 * @author subhrajeetghosh
 */
public class CountPrefixSuffixPair {
    public int countPrefixSuffixPairs(String[] words) { // time complexity - O(n^2 * m)
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    result++;
                }
            }
        }
        isPrefixAndSuffix_2ndMethod("test", "test");
        return result;
    }

    private boolean isPrefixAndSuffix(String str1, String str2) {
        if (str2.length() < str1.length())
            return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i) || str1.charAt(i) != str2.charAt(str2.length() - str1.length() + i)) {
                return false;
            }
        }
        return true;
    }

    // another approch in the 2ndMethod
    private boolean isPrefixAndSuffix_2ndMethod(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }
}
