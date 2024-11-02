package leetCode;

/**
 * https://leetcode.com/problems/circular-sentence
 * 
 * @author subhrajeetghosh
 */
public class CircularSentence {
    public boolean isCircularSentence(String sentence) { // time complexity - O(n)
        String[] sentences = sentence.split(" ");
        boolean result = true;
        char firstCharacter = sentences[0].charAt(0);
        for (int i = 0; i < sentences.length; i++) {
            if (i == sentences.length - 1) {
                if (sentences[i].charAt(sentences[i].length() - 1) != firstCharacter) {
                    result = false;
                    break;
                }
            }
            if (i > 0) {
                if (sentences[i].charAt(0) != sentences[i - 1].charAt(sentences[i - 1].length() - 1)) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    // another way
    public boolean isCircularSentence_2ndMethod(String sentence) { // time complexity - O(n)
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return sentence.charAt(0) == sentence.charAt(sentence.length() - 1);
    }
}
