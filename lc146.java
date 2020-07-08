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





//Solution II
//https://www.youtube.com/watch?v=NDpwj0VWz1U
class LRUCache {

    Node head = new Node();
    Node tail = new Node();
    Map<Integer, Node> node_map;
    int cache_capacity;
    
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }
    
    public void add(Node node) {
        Node head_next = head.next;
        node.next = head_next;
        head_next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    
    public void remove(Node node) {
        Node next_node = node.next;
        Node prev_node = node.prev;
        
        next_node.prev = prev_node;
        prev_node.next = next_node;
    }
    public LRUCache(int capacity) {
        node_map = new HashMap<>(capacity);
        this.cache_capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int result = -1;
        Node node = node_map.get(key);
        if (node != null) {
            remove(node);
            add(node);
            result = node.val;
        }
        return result;
    }
    
    public void put(int key, int value) {
        Node node = node_map.get(key);
        if (node != null) {
            remove(node);
            node.val = value;
            add(node);
        } else {
            if (node_map.size() == cache_capacity) {
                node_map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node new_node = new Node();
            new_node.key = key;
            new_node.val = value;
            
            node_map.put(key, new_node);
            add(new_node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */