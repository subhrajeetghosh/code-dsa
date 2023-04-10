import java.util.HashSet;
import java.util.Set;

public class OptimalPertitionString {
    public int partitionString(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            count++;
            for (int j = i; j < s.length(); j++) {
                if (!set.add(s.charAt(j))) {
                    i = j - 1;
                    break;
                } else if (j == s.length() - 1) {
                    i = j;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = new String("cuieokbs");
        OptimalPertitionString obj = new OptimalPertitionString();
        System.out.println(obj.partitionString(str));
    }
}


/**
 * https://leetcode.com/problems/optimal-partition-of-string/
 */