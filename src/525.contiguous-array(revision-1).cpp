#include <vector>
#include <unordered_map>
using namespace std;
/*
 * @lc app=leetcode id=525 lang=cpp
 *
 * [525] Contiguous Array
 */

// @lc code=start
class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        unordered_map<int, int> map{{0, -1}};
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (map.find(sum) != map.end()) {
                res = max(res, i - map[sum]);
            } else {
                map.insert({sum, i});
            }
        }
        return res;
    }
};
// @lc code=end

