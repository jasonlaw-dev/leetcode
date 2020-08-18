#include <vector>
#include <string>
#include <unordered_map>
using namespace std;
/*
 * @lc app=leetcode id=336 lang=cpp
 *
 * [336] Palindrome Pairs
 */

// @lc code=start
class Solution {
public:
    bool isPalindrome(string str, int i, int j) {
        while (i < j) {
            if (str[i] != str[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    vector<vector<int>> palindromePairs(vector<string>& words) {
        unordered_map<string, int> map;
        vector<vector<int>> res;
        for (int i = 0; i < words.size(); i++) {
            string reversed = words[i];
            reverse(reversed.begin(), reversed.end());
            map.insert({reversed, i});
        }
        for (int i = 0; i < words.size(); i++) {
            string word = words[i];
            // word + ?
            if (word.length() == 0) continue;
            for (int len = 0; len <= word.length(); len++) {
                string prefix = word.substr(0, len);
                if (map.find(prefix) != map.end() && map[prefix] != i && isPalindrome(word, len, word.length() - 1)) {
                    res.push_back({i, map[prefix]});
                }
            }
            // ? + word
            for (int len = 0; len < word.length(); len++) {
                string suffix = word.substr(word.length() - len, len);
                if (map.find(suffix) != map.end() && isPalindrome(word, 0, word.length() - len - 1)) {
                    res.push_back({map[suffix], i});
                }
            }
        }
        return res;
    }
};
// @lc code=end

