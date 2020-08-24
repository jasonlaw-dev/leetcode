#include <stack>
#include <string>
using namespace std;
/*
 * @lc app=leetcode id=224 lang=cpp
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    //"(1-(1-(4-5+2))-3)-(6+8)"
public:
    int calculate(string s) {
        stack<int> st;
        st.push(1);
        int currNum = 0;
        int currSign = 1;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s[i];
            if (c == '(') {
                st.push(currSign * st.top());
                currSign = 1;
            } else if (c == ')' || c == '+' || c == '-') {
                sum += currSign * st.top() * currNum;
                currNum = 0;
                if (c == ')') {
                    st.pop();
                } else if (c == '+') {
                    currSign = 1;
                } else {
                    currSign = -1;
                }
            } else if (c >= '0' && c <= '9') {
                currNum = currNum * 10 + (c - '0');
            }
        }
        sum += currSign * st.top() * currNum;
        return sum;
    }
};
// @lc code=end

