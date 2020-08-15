#include <vector>
using namespace std;

/*
 * @lc app=leetcode id=366 lang=cpp
 *
 * [366] Find Leaves of Binary Tree
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
    int dfs(TreeNode* root, vector<vector<int>> &res) {
        if (root == nullptr) {
            return -1;
        }
        int height = max(dfs(root->left, res), dfs(root->right, res)) + 1;
        if (res.size() == height) {
            res.push_back(vector<int>());
        }
        res[height].push_back(root->val);
        return height;
    }

    vector<vector<int>> findLeaves(TreeNode* root) {
        vector<vector<int>> res;
        dfs(root, res);
        return res;
    }
};
// @lc code=end

