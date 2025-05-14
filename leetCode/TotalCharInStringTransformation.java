package leetCode;

/**
 * https://leetcode.com/problems/total-characters-in-string-after-transformations-i
 * 
 * @author subhrajeetghosh
 */
public class TotalCharInStringTransformation {
    public int lengthAfterTransformations(String s, int t) { // time complexity - O(n + t)
        int[] charArr = new int[26];
        int[] charTmp = new int[26];
        int mod = 1000000007;
        for (char c : s.toCharArray()) {
            charArr[c - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 26; j++) {
                if (charArr[j] != 0) {
                    if (j != 25) {
                        charTmp[j + 1] = charArr[j];
                    } else {
                        charTmp[0] = charArr[j];
                        charTmp[1] = (charTmp[1] + charArr[j]) % mod;
                    }
                }
            }
            for (int j = 0; j < 26; j++) {
                charArr[j] = charTmp[j];
                charTmp[j] = 0;
            }
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + charArr[i]) % mod;
        }
        return result;
    }
}
