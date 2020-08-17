#include <vector>
#include <list>
#include <stack>
#include <cmath>
#include <queue>
using namespace std;
/*
 * @lc app=leetcode id=272 lang=cpp
 *
 * [272] Closest Binary Search Tree Value II
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
    int getNextRight(stack<TreeNode*>& st) {
        TreeNode* curr = st.top();
        st.pop();
        int val = curr->val;
        curr = curr->right;
        while (curr != nullptr) {
            st.push(curr);
            curr = curr->left;
        }
        return val;
    }
    int getNextLeft(stack<TreeNode*>& st) {
        TreeNode* curr = st.top();
        st.pop();
        int val = curr->val;
        curr = curr->left;
        while (curr != nullptr) {
            st.push(curr);
            curr = curr->right;
        }
        return val;
    }
    vector<int> closestKValues(TreeNode* root, double target, int k) {
        stack<TreeNode*> leftStack;
        stack<TreeNode*> rightStack;
        TreeNode* curr = root;
        while (curr != nullptr) {
            if (curr->val == target) {
                leftStack.push(curr);
                break;
            } else if (curr->val < target) {
                leftStack.push(curr);
                curr = curr->right;
            } else {
                curr = curr->left;
            }
        }
        curr = root;
        while (curr != nullptr) {
            if (curr->val == target) {
                rightStack.push(curr);
                break;
            } else if (curr->val > target) {
                rightStack.push(curr);
                curr = curr->left;
            } else {
                curr = curr->right;
            }
        }
        vector<int> res;
        if (leftStack.size() && rightStack.size() && leftStack.top() == rightStack.top()) {
            getNextRight(rightStack);
        }
        while (k > 0) {
            k--;
            if (rightStack.size() == 0 || leftStack.size() != 0 && (target - leftStack.top()->val <= rightStack.top()->val - target)) {
                res.push_back(getNextLeft(leftStack));
            } else {
                res.push_back(getNextRight(rightStack));
            }
        }
        return res;
    }
};
// @lc code=end

