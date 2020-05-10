import java.util.Stack;

/*
 * @lc app=leetcode id=331 lang=java
 *
 * [331] Verify Preorder Serialization of a Binary Tree
 */

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
       int diff = 1;
       for (int i = 0; i <= preorder.length(); i++) {
           char c = i != preorder.length() ? preorder.charAt(i) : ',';
           if (c == ',') {
               if (preorder.charAt(i - 1) == '#') {
                   diff--;
                   if (i != preorder.length() && diff == 0) {
                       return false;
                   }
               } else {
                   diff++;
               }
           }
       }
       return diff == 0;
    }
}
// @lc code=end

