#include <vector>
using namespace std;
/*
 * @lc app=leetcode id=719 lang=cpp
 *
 * [719] Find K-th Smallest Pair Distance
 */

// @lc code=start
class Solution {
private:
    int count(vector<int>& nums, int target) {
        int count = 0;
        for (int i = 0, j = 0; i < nums.size() - 1; i++) {
            while (j < nums.size() && nums[j] - nums[i] <= target) {
                j++;
            }
            count += j - i - 1;
        }
        return count;
    }
public:
    int smallestDistancePair(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int low = 0;
        int high = nums[nums.size() - 1] - nums[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int lowerEqual = count(nums, mid);
            if (lowerEqual >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
};
// @lc code=end

