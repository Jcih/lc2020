class TrieNode {
    public boolean isLeaf;
    HashMap<Character, TrieNode> children;
    
    public TrieNode() {
        isLeaf = false;
        children = new HashMap<Character, TrieNode>();
    }
}


class Trie {

    
    /** Initialize your data structure here. */
   
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!children.containsKey(c)) {
                TrieNode node = new TrieNode();
                children.put(c,node);
            }
            
            TrieNode node = children.get(c);
            if (i == word.length() - 1) {
                node.isLeaf = true;
            }
            children = node.children;
            
        }
    }
    
    
    private TrieNode searchNode(String pre) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode node = root;
        for (int i = 0; i < pre.length(); i++) {
            if (!children.containsKey(pre.charAt(i))) {
                return null;
            }
            node = children.get(pre.charAt(i));
            children = node.children;
        }
        return node;
    }
    
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
       TrieNode node = searchNode(word);
        return node != null && node.isLeaf == true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */