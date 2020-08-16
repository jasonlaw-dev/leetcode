#include <vector>
#include <unordered_map>
using namespace std;
/*
 * @lc app=leetcode id=325 lang=cpp
 *
 * [325] Maximum Size Subarray Sum Equals k
 */

// @lc code=start
class Solution {
public:
    int maxSubArrayLen(vector<int>& nums, int k) {
        unordered_map<int, int> map{{0, -1}};
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            if (map.find(sum - k) != map.end()) {
                res = max(res, i - map[sum - k]);
            }
            map.insert({{sum, i}});
        }
        return res;
    }
};
// @lc code=end

