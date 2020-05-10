import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
 * @lc app=leetcode id=950 lang=java
 *
 * [950] Reveal Cards In Increasing Order
 */

// @lc code=start
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> queue = new ArrayDeque<>(deck.length);
        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }
        int[] res = new int[deck.length];
        boolean take = true;
        int i = 0;
        while (!queue.isEmpty()) {
            if (take) {
                res[queue.poll()] = deck[i++];
            } else {
                queue.offer(queue.poll());
            }
            take = !take;
        }
        return res;
    }
}
// @lc code=end

