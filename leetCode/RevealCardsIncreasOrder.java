package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/reveal-cards-in-increasing-order
 * 
 * @author subhrajeetghosh
 */
public class RevealCardsIncreasOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] result = new int[deck.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }
        for (int i = 0; i < deck.length; i++) {
            result[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }
        return result;
    }
}
