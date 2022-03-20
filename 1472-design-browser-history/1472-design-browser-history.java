class BrowserHistory {
    
    class Node {
        String value;
        Node next;
        Node prev;
        
        public Node(String value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    
    Node curr;

    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
    }
    
    public String back(int steps) {
        while(curr.prev != null && steps > 0) {
            curr = curr.prev;
            steps--;
        }
        return curr.value;
    }
    
    public String forward(int steps) {
        while (curr.next != null && steps > 0) {
            curr = curr.next;
            steps--;
        }
        return curr.value;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */