package leetCode;

public class CountVowelInRanges {
    // Bruteforce
    public int[] vowelStrings(String[] words, int[][] queries) {
        boolean[] isVowel = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                isVowel[i] = true;
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (isVowel[j]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    private boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
