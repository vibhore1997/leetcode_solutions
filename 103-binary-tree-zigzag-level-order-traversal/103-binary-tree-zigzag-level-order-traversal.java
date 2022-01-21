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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        
        while (queue.size() != 0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            
            while (size-- > 0) {
                TreeNode node = queue.poll();
                
                list.add(node.val);
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (level % 2 == 0) {
                res.add(list);
            } else {
                Collections.reverse(list);
                res.add(list);
            }
            level++;
        }
        return res;
    }
}