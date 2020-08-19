#include <vector>
#include <queue>
using namespace std;

/*
 * @lc app=leetcode id=373 lang=cpp
 *
 * [373] Find K Pairs with Smallest Sums
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        vector<vector<int>> res;
        if (nums1.size() == 0 || nums2.size() == 0) {
            return res;
        }
        auto compare = [&nums1, &nums2](vector<int> &a, vector<int> &b) { return nums1[a[0]]+nums2[a[1]] > nums1[b[0]] + nums2[b[1]]; };
        priority_queue<vector<int>, vector<vector<int>>, decltype(compare)> q(compare);
        for (int i = 0; i < nums1.size(); i++) {
            q.push({i,0});
        }
        while (q.size() && res.size() < k) {
            auto ij = q.top();
            int i = ij[0];
            int j = ij[1];
            q.pop();
            res.push_back({nums1[i], nums2[j]});
            if (j < nums2.size() - 1) {
                q.push({i, j + 1});
            }
        }
        return res;
    }
};
// @lc code=end

