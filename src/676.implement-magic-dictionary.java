import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=676 lang=java
 *
 * [676] Implement Magic Dictionary
 */

// @lc code=start
class MagicDictionary {

    Map<String, Character> map = new HashMap<>();

    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            char[] w = word.toCharArray();
            for (int i = 0; i < w.length; i++) {
                char tmp = w[i];
                w[i] = '*';
                String key = new String(w);
                if (map.containsKey(key)) {
                    map.put(key, ' ');
                } else {
                    map.put(key, tmp);
                }
                w[i] = tmp;
            }
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            char tmp = w[i];
            w[i] = '*';
            String key = new String(w);
            if (map.containsKey(key) && map.get(key) != tmp) {
                return true;
            }
            w[i] = tmp;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

