#include <vector>
#include <string>
#include <unordered_map>
using namespace std;
/*
 * @lc app=leetcode id=642 lang=cpp
 *
 * [642] Design Search Autocomplete System
 */

// @lc code=start
struct TrieNode {
    vector<TrieNode*> children;
    vector<int> indexes;
    TrieNode(): children(vector<TrieNode*>(256, nullptr)) {};
};

class AutocompleteSystem {
private:
    unordered_map<string, int> map;
    vector<string> sentences;
    TrieNode* root;
    TrieNode* curr;
    string currString = "";
    void addSentence(string& str, int idx) {
        curr = root;
        for (int i = 0; i < str.length(); i++) {
            int c = str[i];
            if (curr->children[c] == nullptr) {
                curr->children[c] = new TrieNode();
            }
            curr = curr->children[c];
            curr->indexes.push_back(idx);
        }
    }
public:
    AutocompleteSystem(vector<string>& sentences, vector<int>& times) {
        root = new TrieNode();
        curr = root;
        this->sentences = sentences;
        for (int i = 0; i < sentences.size(); i++) {
            addSentence(sentences[i], i);
            map.insert({sentences[i], times[i]});
        }
        curr = root;
    }
    
    vector<string> input(char c) {
        vector<string> candidates;
        if (c == '#') {
            curr = root;
            if (map.find(currString) == map.end()) {
                addSentence(currString, sentences.size());
                sentences.push_back(currString);
                map.insert({currString, 1});
            } else {
                map[currString] = map[currString] + 1;
            }
            curr = root;
            currString = "";
            return candidates;
        }
        currString += c;
        if (curr->children[c] == nullptr) {
            curr->children[c] = new TrieNode();
        }
        curr = curr->children[c];
        for (int i : curr->indexes) {
            candidates.push_back(sentences[i]);
        }
        auto compare = [&](string& a, string& b) {
            int x = map[a];
            int y = map[b];
            if (x != y) {
                return x > y;
            }
            return a < b;
        };
        sort(candidates.begin(), candidates.end(), compare);
        return candidates.size() <= 3 ? candidates : vector<string>(candidates.begin(), candidates.begin() + 3);
    }
};

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem* obj = new AutocompleteSystem(sentences, times);
 * vector<string> param_1 = obj->input(c);
 */
// @lc code=end

