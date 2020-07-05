import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=1505 lang=java
 *
 * [1505] Minimum Possible Integer After at Most K Adjacent Swaps On Digits
 */

// @lc code=start
class Solution {
    int[] preSums;
    public String minInteger(String num, int k) {
        int n = num.length();
        preSums = new int[n + 1];
        if (k >= (n - 1) * n / 2) {
            char[] str = num.toCharArray();
            Arrays.sort(str);
            return new String(str);
        }
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = n - 1; i >= 0; i--) {
            buckets.get(num.charAt(i) - '0').add(i);
        }
        
        boolean[] used = new boolean[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            int j = num.charAt(i) - '0';
            for (int b = 0; b < j && k > 0; b++) {
                List<Integer> bucket = buckets.get(b);
                while (!bucket.isEmpty() && k > 0) {
                    int first = bucket.get(bucket.size() - 1);
                    if (first <= i) {
                        bucket.remove(bucket.size() - 1);
                    } else {
                        int moves = first - i - (query(first - 1) - query(i));
                        if (moves <= k) {
                            sb.append(b);
                            update(first);
                            bucket.remove(bucket.size() - 1);
                            k -= moves;
                            used[first] = true;
                        } else {
                            break;
                        }
                    }
                }
            }
            sb.append(j);
        }
        return sb.toString();
    }
    private void update(int index) {
        for (int i = index + 1; i < preSums.length; i += i & (-i)) {
            preSums[i]++;
        }
    }
    private int query(int index) {
        int sum = 0;
        for (int i = index + 1; i > 0; i -= i & (-i)) {
            sum += preSums[i];
        }
        return sum;
    }
}
// @lc code=end

