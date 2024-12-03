package leetCode;

/**
 * https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence
 * 
 * @author subhrajeetghosh
 */
public class CheckWordPrefix {
    public int isPrefixOfWord(String sentence, String searchWord) { // time complexity - O(n)
        int index = 1;
        for (String str : sentence.split(" ")) {
            if (str.indexOf(searchWord) == 0) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
