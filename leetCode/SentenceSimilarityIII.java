package leetCode;

/**
 * https://leetcode.com/problems/sentence-similarity-iii/
 * 
 * @author subhrajeetghosh
 */
public class SentenceSimilarityIII {
    public boolean areSentencesSimilar(String sentence1, String sentence2) { // time complexity - O(n + m)
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        int i = 0, j = arr1.length, k = arr2.length;
        while (i < Math.min(j, k)) {
            if (arr1[i].equals(arr2[i])) {
                i++;
            } else {
                break;
            }
        }
        if (i == j || i == k)
            return true;
        while (i < Math.min(j, k)) {
            if (arr1[j - 1].equals(arr2[k - 1])) {
                j--;
                k--;
            } else {
                break;
            }
        }
        if (i == j || i == k)
            return true;
        return false;
    }
}
