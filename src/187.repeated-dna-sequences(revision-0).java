import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */
// AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        int temp = 0;
        int mask = 0xFFFFF;
        Set<Integer> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        Map<Character, Integer> bitMap = new HashMap<>();
        bitMap.put('A', 0);
        bitMap.put('C', 1);
        bitMap.put('G', 2);
        bitMap.put('T', 3);
        for (int i = 0; i < 9; i++) {
            temp = temp << 2 | bitMap.get(s.charAt(i));
        }
        for (int i = 9; i < s.length(); i++) {
            temp = (temp << 2 | bitMap.get(s.charAt(i))) & mask;
            if (!seen.add(temp)) {
                repeated.add(s.substring(i - 9, i + 1));
            }
        }
        return new ArrayList<>(repeated);
    }
}
// @lc code=end

