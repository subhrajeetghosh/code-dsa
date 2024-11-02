package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/divide-players-into-teams-of-equal-skill
 * 
 * @author subhrajeetghosh
 */
public class DividePlayerSkill {
    public long dividePlayers(int[] skill) { // time complexity - O (n log n)
        Arrays.sort(skill);
        int currentFixSum = skill[0] + skill[skill.length - 1];
        int i = 0, j = skill.length - 1;
        long result = 0;
        while (i < j) {
            if (skill[i] + skill[j] == currentFixSum) {
                result += skill[i] * skill[j];
            } else {
                return -1;
            }
            i++;
            j--;
        }
        return result;
    }
}
