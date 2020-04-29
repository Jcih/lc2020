class LRUCache {
    static class Node {
        private int key;
        private int value;
        Node prev, next;
        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> map;
    private Node dummyhead, dummytail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dummyhead = new Node(-1, -1);
        this.dummytail = new Node(-1, -1);
        this.dummyhead.next = this.dummytail;
        this.dummytail.prev = this.dummyhead;
        
    }
    
    public int get(int key) {
        Node node = getNode(key);
        if (node == null)
            return -1;
        return node.value;
    }
    
    Node getNode(int key) {
        Node node = map.get(key);
        if (node == null)
            return null;
        disconnect(node);
        insertHead(node);
        return node;
    }
    
    void disconnect(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    void insertHead(Node node) {
        node.next = dummyhead.next;
        dummyhead.next.prev = node;
        node.prev = dummyhead;
        dummyhead.next = node;
    }
    
    
    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
        } else {
            node = new Node(key, value);
            insertHead(node);
            map.put(key, node);
            if(map.size() > capacity) {
                Node tail = dummytail.prev;
                disconnect(tail);
                map.remove(tail.key);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */