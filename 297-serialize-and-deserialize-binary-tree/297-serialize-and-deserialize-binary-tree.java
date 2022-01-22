/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int idx = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper1(root, sb);
        // System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return helper2(data);
    }
    
    private void helper1(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N.");
            return;
        }
        
        sb.append(root.val).append(".");
        
        helper1(root.left, sb);
        helper1(root.right, sb);
    }
    
    private TreeNode helper2(String data) {
        if (idx >= data.length() - 2) {
            return null;
        }
        if (data.charAt(idx) == 'N') {
            idx += 2;
            return null;
        }
        
        StringBuilder s = new StringBuilder();
        while(data.charAt(idx) != '.') {
            s.append(data.charAt(idx));
            idx++;
        }
        idx++;
        int val = Integer.valueOf(s.toString());
        
        TreeNode root = new TreeNode(val);
        
        root.left = helper2(data);
        root.right = helper2(data);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));