#include <vector>
#include <string>
#include <unordered_map>
using namespace std;

/*
 * @lc app=leetcode id=737 lang=cpp
 *
 * [737] Sentence Similarity II
 */

// @lc code=start
class Solution {
private:
    unordered_map<string, string> parents;
    string find(string& i) {
        if (parents[i] != i) {
            parents[i] = find(parents[i]);
        }
        return parents[i];
    }
    void merge(string& i, string& j) {
        string x = find(i);
        string y = find(j);
        if (x != y) {
            parents[x] = y;
        }
    }
public:
    bool areSentencesSimilarTwo(vector<string>& words1, vector<string>& words2, vector<vector<string>>& pairs) {
        if (words1.size() != words2.size()) {
            return false;
        }
        int n = words1.size();
        for (auto& pair : pairs) {
            if (parents.find(pair[0]) == parents.end()) {
                parents.insert({pair[0], pair[0]});
            }
            if (parents.find(pair[1]) == parents.end()) {
                parents.insert({pair[1], pair[1]});
            }
            merge(pair[0], pair[1]);
        }
        for (int i = 0; i < n; i++) {
            if (words1[i] == words2[i]) {
                continue;
            }
            if (parents.find(words1[i]) == parents.end() ||  parents.find(words2[i]) == parents.end() || find(words1[i]) != find(words2[i])) {
                return false;
            }
        }
        return true;
    }
};
// @lc code=end

