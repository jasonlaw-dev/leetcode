#include <vector>
#include <string>
using namespace std;
/*
 * @lc app=leetcode id=10 lang=cpp
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
public:
    bool isMatch(string s, string p) {
        vector<vector<bool>> dp(s.length() + 1, vector<bool>(p.length() + 1, false));
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i += 2) {
            if (p[i] == '*') {
                dp[0][i + 1] = true;
            } else {
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                bool isCurrMatch = p[j] == '.' || s[i] == p[j];
                if (j + 1 < p.length() && p[j + 1] == '*') {
                    dp[i+1][j+2] = dp[i+1][j] || isCurrMatch && dp[i][j+2];
                    j++;
                } else {
                    dp[i+1][j+1] = isCurrMatch && dp[i][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
};
// @lc code=end

