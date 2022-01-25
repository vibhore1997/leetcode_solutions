class LRUCache {
    
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }
    
    private Node head;
    private Node tail;
    private Map<Integer, Node> hmap;
    private int size;
    private int capacity;
    
    private void addNode(Node node) { // add in front
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node) { // remove in O(1)
        Node previous = node.prev;
        Node nextNode = node.next;
        
        previous.next = nextNode;
        nextNode.prev = previous;
    }
    
    private void moveToHead(Node node) { // move to head
        removeNode(node);
        addNode(node);
    }
    
    private Node popTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        hmap = new HashMap<>();
        
        head = new Node();
        tail = new Node();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = hmap.get(key);
        if (node == null) return -1;
        
        moveToHead(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = hmap.get(key);
        
        if (node == null) {
            
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            
            addNode(newNode);
            hmap.put(key, newNode);
            size++;
            
            if (size > capacity) {
                Node pNode = popTail();
                hmap.remove(pNode.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */