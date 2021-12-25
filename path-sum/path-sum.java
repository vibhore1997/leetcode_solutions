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
    boolean found = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0);
        return found;
    }
    
    void helper(TreeNode root, int target, int currSum) {
        if (root == null) {
            return;
        }
        
        currSum += root.val;
        
        if(root.left == null && root.right == null) {
            if (currSum == target) {
                found = true;
            }
        }
        
        helper(root.left, target, currSum);
        helper(root.right, target, currSum);
    }
}