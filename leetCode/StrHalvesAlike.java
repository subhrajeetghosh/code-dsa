package leetCode;

/**
 * https://leetcode.com/problems/determine-if-string-halves-are-alike
 * 
 * @author subhrajeetghosh
 */
public class StrHalvesAlike {
    public boolean halvesAreAlike(String s) { // time complexity - O(N)
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int midLength = length / 2;
        int counter1 = 0;
        int counter2 = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (i < midLength) {
                if (checkIsVowel(Character.toLowerCase(charArray[i]))) {
                    counter1++;
                }
            } else {
                if (checkIsVowel(Character.toLowerCase(charArray[i]))) {
                    counter2++;
                }
            }
        }
        return counter1 == counter2;
    }

    private boolean checkIsVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
