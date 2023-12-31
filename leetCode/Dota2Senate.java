package leetCode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * {@link} https://leetcode.com/problems/dota2-senate
 * 
 * @author subhrajeetghosh
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

    // Queue Logic
    public String predictPartyVictory_2ndMethod(String senate) {
        Queue<Integer> qu1 = new LinkedList<Integer>();
        Queue<Integer> qu2 = new LinkedList<Integer>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                qu1.add(i);
            } else {
                qu2.add(i);
            }
        }
        while (!qu1.isEmpty() && !qu2.isEmpty()) {
            if (qu1.peek() < qu2.peek()) {
                int currentWinner = qu1.poll() + senate.length();
                qu2.poll();
                qu1.offer(currentWinner);
            } else {
                int currentWinner = qu2.poll() + senate.length();
                qu1.poll();
                qu2.offer(currentWinner);
            }
        }
        return qu1.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        System.out.println(new Dota2Senate().predictPartyVictory("RRDDD"));
    }
}
