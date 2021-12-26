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
    int total = 0;
    public int pathSum(TreeNode root, int targetSum) {
        helper1(root, targetSum);
        return total;
    }
    
    private void helper1(TreeNode root, int target) {
        if(root == null){
            return;
        }
        
        helper2(root, target);
        
        helper1(root.left, target);
        helper1(root.right, target);
    }
    
    private void helper2(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        
        if (target - root.val == 0) {
            total++;
        }
        
        helper2(root.left, target - root.val);
        helper2(root.right, target - root.val);
    }
}