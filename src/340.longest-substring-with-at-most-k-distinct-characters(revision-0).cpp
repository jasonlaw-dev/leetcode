#include <string>
#include <unordered_map>
using namespace std;
/*
 * @lc app=leetcode id=340 lang=cpp
 *
 * [340] Longest Substring with At Most K Distinct Characters
 */

// @lc code=start
class Solution {
public:
    int lengthOfLongestSubstringKDistinct(string s, int k) {
        int len = 0;
        if (k == 0) {
            return 0;
        }
        unordered_map<char, int> map;
        int unique = 0;
        for (int i = 0, j = 0; j < s.size(); j++) {
            if (map.find(s[j]) == map.end()) {
                map.insert({s[j], 0});
            }
            if (map[s[j]]++ == 0) {
                unique++;
            }
            while (unique > k) {
                if (--map[s[i++]] == 0) {
                    unique--;
                }
            }
            len = max(len, j - i + 1);
        }
        return len;
    }
};
// @lc code=end

