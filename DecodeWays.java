public class DecodeWays {

    //Bruteforce way with recursion
    int count = 0;

    public int decodeStringWays(String s) {
        recForCount(s, 0);
        return count;
    }

    public void recForCount(String s, int start) {
        if (start == s.length()) {
            count++;
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i - start <= 1) {
                String subString = s.substring(start, i + 1);
                if (Integer.parseInt(subString) >= 1 && Integer.parseInt(subString) < 27
                        && subString.charAt(0) != '0') {
                    recForCount(s, i + 1);
                }
            }
        }
    }

    //Memorization


    public static void main(String[] args) {
        DecodeWays obj = new DecodeWays();
        System.out.println(obj.decodeStringWays("121"));
    }
}


/*
 * Dynamic Problem
 * https://leetcode.com/problems/decode-ways/
 */