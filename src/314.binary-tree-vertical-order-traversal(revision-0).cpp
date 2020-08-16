#include <vector>
#include <unordered_map>
#include <queue>
using namespace std;
/*
 * @lc app=leetcode id=314 lang=cpp
 *
 * [314] Binary Tree Vertical Order Traversal
 */
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    vector<vector<int>> verticalOrder(TreeNode* root) {
        if (root == nullptr) {
            return vector<vector<int>>();
        }
        unordered_map<int, vector<int>> map;
        queue<pair<TreeNode*, int>> q;
        int minIndex = 0;
        int maxIndex = 0;
        q.push({root, 0});
        while (q.size()) {
            auto p = q.front();
            q.pop();
            TreeNode* node = p.first;
            int index = p.second;
            if (map.find(index) == map.end()) {
                map.insert({index, vector<int>()});
            }
            map[index].push_back(node->val);
            minIndex = min(minIndex, index);
            maxIndex = max(maxIndex, index);
            if (node->left != nullptr) {
                q.push({node->left, index - 1});
            }
            if (node->right != nullptr) {
                q.push({node->right, index + 1});
            }
        }
        vector<vector<int>> res;
        for (int i = minIndex; i <= maxIndex; i++) {
            res.push_back(map[i]);
        }
        return res;
    }
};
// @lc code=end

