import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=632 lang=java
 *
 * [632] Smallest Range Covering Elements from K Lists
 */

// @lc code=start
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // [listIndex, intIndex]
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            List<Integer> aList = nums.get(a[0]);
            List<Integer> bList = nums.get(b[0]);

            if (a[1] == aList.size() - 1) {
                return 1;
            }
            if (b[1] == bList.size() - 1) {
                return -1;
            }

            int aVal = aList.get(a[1]);
            int bVal = bList.get(b[1]);
            if (aVal == bVal) {
                return aList.get(a[1] + 1) - bList.get(b[1] + 1);
            }
            return aVal - bVal;
        });

        int[] pair = new int[2];

        pair[0] = Integer.MAX_VALUE;
        pair[1] = Integer.MIN_VALUE;


        int globalMin = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            queue.add(new int[] {i, 0});
            List<Integer> list = nums.get(i);
            pair[0] = Math.min(pair[0], list.get(0));
            pair[1] = Math.max(pair[1], list.get(0));
            if (list.size() == 1) {
                globalMin = Math.min(globalMin, list.get(0));
            }
        }
        int[] res = new int[] {pair[0], pair[1]};



        while (pair[1] - pair[0] != 0) {
            int[] next = queue.poll();
            // System.out.println("Polled " + nums.get(next[0]).get(next[1]) + " from list " + next[0]);


            if (nums.get(next[0]).size() - 1 == next[1]) {
                break;
            }

            if (nums.get(next[0]).size() - 2 == next[1]) {
                globalMin = Math.min(globalMin, nums.get(next[0]).get(next[1] + 1));
            }

            queue.add(new int[] {next[0], next[1] + 1});

            int[] min = queue.peek();
            pair[0] = Math.min(globalMin, nums.get(min[0]).get(min[1]));
            pair[1] = Math.max(pair[1], nums.get(next[0]).get(next[1] + 1));

            // System.out.println(pair[0] + " " + pair[1] + " " + res[0] + " "+ res[1]);
            
            if (pair[1] - pair[0] < res[1] - res[0]) {
                res = new int[] {pair[0], pair[1]};;
            }
        }

        return res;
    }
}
// @lc code=end

