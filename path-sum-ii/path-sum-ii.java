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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(root, targetSum, res, curr);
        return res;
    }
    
    private void helper(TreeNode root, int target, List<List<Integer>> res, List<Integer> curr) {
        if (root == null) {
            return;
        }
        
        curr.add(root.val);
        
        if (root.left == null && root.right == null && target - root.val == 0) {
            res.add(new ArrayList<>(curr));
        }
        
        if (root.left != null) {
            helper(root.left, target - root.val, res, curr);
            curr.remove(curr.size() - 1);
        }
        
        if (root.right != null) {
            helper(root.right, target - root.val, res, curr);
            curr.remove(curr.size() - 1);
        }
    }
}