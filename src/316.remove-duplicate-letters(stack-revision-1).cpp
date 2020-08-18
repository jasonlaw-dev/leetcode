#include <vector>
#include <string>
#include <stack>
using namespace std;
/*
 * @lc app=leetcode id=316 lang=cpp
 *
 * [316] Remove Duplicate Letters
 */

// @lc code=start
class Solution {
public:
    string removeDuplicateLetters(string s) {
        vector<int> count(26, 0);
        vector<bool> used(26, false);
        stack<char> st;
        for (int i = 0; i < s.size(); i++) {
            count[s[i] - 'a']++;
        }
        for (int i = 0; i < s.size(); i++) {
            char c = s[i];
            if (!used[c - 'a']) {
                while (st.size() && count[st.top()-'a'] > 0 && c < st.top()) {
                    used[st.top() - 'a'] = false;
                    st.pop();
                }
                st.push(c);
                used[c - 'a'] = true;
            }
            count[c-'a']--;
        }
        char res[st.size() + 1];
        res[st.size()] = '\0';
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.top();
            st.pop();
        }
        return string(res);
    }
};
// @lc code=end

