/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int[] preorder, int start, int end) {
        
        if (i == preorder.length) {
            return null;
        }
        
        int value = preorder[i];
        
        if (value < start || value > end) {
            return null;
        }
        
        i++;
        TreeNode root = new TreeNode(value);
        root.left = helper(preorder, start, value);
        root.right = helper(preorder, value, end);
        
        return root;
    }
}