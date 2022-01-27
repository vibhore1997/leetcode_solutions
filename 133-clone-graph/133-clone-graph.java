/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> hmap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        
        if (node == null) {
            return null;
        }
        
        queue.offer(node);
        
        while (queue.size() != 0) {
            Node currNode = queue.poll();
            
            if (!hmap.containsKey(currNode)) {
                Node newNode = new Node(currNode.val);
                hmap.put(currNode, newNode);
            }
            
            
            for(Node eleNode : currNode.neighbors) {
                if (hmap.containsKey(eleNode)) {
                    hmap.get(currNode).neighbors.add(hmap.get(eleNode));
                } else {
                    Node newNode1 = new Node(eleNode.val);
                    hmap.put(eleNode, newNode1);
                    hmap.get(currNode).neighbors.add(newNode1);
                    queue.offer(eleNode);
                }
            }
        }
        return hmap.get(node);
    }
}