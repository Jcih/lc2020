//Solution I DFS


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
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        map.put(node, new Node(node.val, new ArrayList<>()));
        for (Node neighbor : node.neighbors) {
            if (map.containsKey(neighbor)) {
                map.get(node).neighbors.add(map.get(neighbor));
            } else {
                map.get(node).neighbors.add(cloneGraph(neighbor));
            }
        }
        return map.get(node);
    }
}

//Solution II BFS
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
        
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        
        queue.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Node h = queue.poll();
            for (Node neighbor : h.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                map.get(h).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}




//Solution III
class Solution {
    HashMap<Node, Node> clonedNodes;
    public Solution() {
        clonedNodes = new HashMap<Node,Node>();
    }

    public Node cloneGraph(Node node) {
        if(node==null) return node;
        if(clonedNodes.get(node) != null)
            return clonedNodes.get(node);
        
        Node clone = new Node(node.val);
        clonedNodes.put(node, clone);
        
        ArrayList<Node> neighbors = new ArrayList<Node>();
        for(int i=0; i<node.neighbors.size(); i++) {
            neighbors.add(cloneGraph(node.neighbors.get(i)));
        }
        clone.neighbors = neighbors;
        
        return clone;
    }
}