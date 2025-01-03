package leetCode;

public class CountVowelInRanges {
    // Bruteforce
    public int[] vowelStrings_2ndMethod(String[] words, int[][] queries) { // time complexity - O(k * n)
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

    // Optimized
    public int[] vowelStrings(String[] words, int[][] queries) { //time complexity - O(n + k)
        int[] prefixSum = new int[words.length];
        int totalCount = 0;
        for (int i = 0; i < words.length; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                totalCount++;
            }
            prefixSum[i] = totalCount;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = prefixSum[queries[i][1]] - (queries[i][0] == 0 ? 0 : prefixSum[queries[i][0] - 1]);
        }
        return result;
    }
}
