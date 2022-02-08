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
    int maxi = -20000;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxi;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        
        maxi = Math.max(maxi, left + right + root.val);
        
        return root.val + Math.max(left, right);
    }
}