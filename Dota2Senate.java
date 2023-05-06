/**
 * https://leetcode.com/problems/dota2-senate
 * 
 * @author Subhrajeet Ghosh
 */

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        if (senate.length() < 2) {
            return senate.charAt(0) == 'R' ? "Radiant" : "Dire";
        }
        int checkPoint = 0;
        char currentChar = senate.charAt(checkPoint);
        boolean isCheck = true;
        boolean[] isDestroyed = new boolean[senate.length()];
        while (isCheck) {
            int i = checkPoint;
            isCheck = false;
            Boolean leftCheck = true;
            currentChar = senate.charAt(checkPoint);
            while (i < senate.length()) {
                if (senate.charAt(i) != currentChar && !isDestroyed[i]) {
                    isDestroyed[i] = true;
                    isCheck = true;
                    int checkPointDecider = checkPoint + 1;
                    while (true) {
                        if (checkPointDecider >= senate.length()) {
                            checkPointDecider = 0;
                        }
                        if (isDestroyed[checkPointDecider]) {
                            checkPointDecider++;

                        } else {
                            break;
                        }
                    }
                    if (checkPointDecider == checkPoint) {
                        return senate.charAt(checkPoint) == 'R' ? "Radiant" : "Dire";
                    } else {
                        checkPoint = checkPointDecider;
                    }
                    break;
                } else {
                    i++;
                    if (i >= senate.length() && leftCheck) {
                        i = 0;
                        leftCheck = false;
                    }
                }
            }
        }
        return senate.charAt(checkPoint) == 'R' ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        System.out.println(new Dota2Senate().predictPartyVictory("RRDDD"));
    }
}
