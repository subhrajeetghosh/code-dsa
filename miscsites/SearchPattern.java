package miscsites;

import java.util.ArrayList;

/**
 * https://www.geeksforgeeks.org/problems/search-pattern-rabin-karp-algorithm--141631/1
 * 
 * @author subhrajeetghosh
 */
public class SearchPattern {
    ArrayList<Integer> search(String pat, String txt) { // time complexity - O(n * m)
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == pat.charAt(0)) {
                int j = 0, tmpI = i;
                while (pat.length() > j && txt.length() > i) {
                    if (pat.charAt(j) == txt.charAt(i)) {
                        j++;
                        i++;
                    } else {
                        break;
                    }
                }
                if (pat.length() == j) {
                    result.add(tmpI + 1);
                }
                i = tmpI;
            }
        }
        return result;
    }

    ArrayList<Integer> search_2ndMethod(String pat, String txt) { // time complexity - O(n * m)
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < txt.length(); i++) {
            String subStr = txt.substring(i);
            int foundIndex = subStr.indexOf(pat);
            if (foundIndex >= 0) {
                result.add(foundIndex + 1 + i);
                i += foundIndex;
            }
        }
        return result;
    }

    ArrayList<Integer> search_3rdMethod(String pat, String txt) { // time complexity - O(n + m)
        int mode = 1000000007;
        int base = 31;
        long basePower = 1;
        for (int i = 0; i < pat.length() - 1; i++) {
            basePower = (basePower * base) % mode;
        }
        long patternHash = 0, windowHash = 0;
        for (int i = 0; i < pat.length(); i++) {
            patternHash = (patternHash * base + (pat.charAt(i) - 'a' + 1)) % mode;
            windowHash = (windowHash * base + (txt.charAt(i) - 'a' + 1)) % mode;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= txt.length() - pat.length(); i++) {
            if (patternHash == windowHash && txt.substring(i, i + pat.length()).equals(pat)) {
                result.add(i + 1);
            }
            if (txt.length() - pat.length() > i) {
                windowHash -= ((txt.charAt(i) - 'a' + 1) * basePower) % mode;
                if (windowHash < 0)
                    windowHash += mode;
                windowHash = (windowHash * base + (txt.charAt(i + pat.length()) - 'a' + 1)) % mode;
            }
        }
        return result;
    }
}
