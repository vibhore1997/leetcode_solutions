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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b - a); // Max heap
        count = k;
        helper(root, queue);
        return queue.peek();
    }
    
    private void helper(TreeNode root, Queue<Integer> queue) {
        if (root == null) {
            return;
        }
        
        helper(root.left, queue);
        
        if (count == 0) {
            return;
        }
        count--;
        queue.offer(root.val);
        
        
        helper(root.right, queue);
    }
}