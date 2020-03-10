/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 */

// @lc code=start

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class WordDictionary {

    TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (curr.children[c] == null) {
                curr.children[c] = new TrieNode();
            }
            curr = curr.children[c];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return bt(word, 0, root);
    }

    private boolean bt(String word, int i, TrieNode curr) {
        if (i == word.length()) {
            return curr.isEnd;
        }
        char c = word.charAt(i);
        if (c != '.') {
            return curr.children[c - 'a'] != null && bt(word, i + 1, curr.children[c - 'a']);
        } else {
            for (int k = 0; k < 26; k++) {
                if (curr.children[k] != null && bt(word, i + 1, curr.children[k])) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

