import java.util.Stack;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Element {
    TreeNode node;
    int size;
    Element(TreeNode node, int size) {
        this.node = node;
        this.size = size;
    }
}

class Codec {

    public void serializeHelper(TreeNode root, int depth, int index, StringBuilder sb) {
        if (root == null) {
            return;
        }
        if (depth > 0) {
            sb.append(',');
        }
        sb.append(depth);
        sb.append(',');
        sb.append(index);
        sb.append(',');
        sb.append(root.val);
        serializeHelper(root.left, depth + 1, index * (depth + 1), sb);
        serializeHelper(root.right, depth + 1, index * (depth + 1) + 1, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, 0, 0, sb);
        return sb.toString();
    }


    private Element deserializeHelper(int[] A, int depth, int index, int i) {
        if (i < A.length && A[i] == depth && A[i + 1] == index) {
            TreeNode curr = new TreeNode(A[i + 2]);
            i += 3;
            Element left = deserializeHelper(A, depth + 1, index * (depth + 1), i);
            i += left.size * 3;
            Element right = deserializeHelper(A, depth + 1, index * (depth + 1) + 1, i);
            curr.left = left.node;
            curr.right = right.node;
            return new Element(curr, 1 + left.size + right.size);
        }
        return new Element(null, 0);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null; 
        String[] strs = data.split(",");
        int[] A = new int[strs.length];
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(strs[i]);
        }
        return deserializeHelper(A, 0, 0, 0).node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

