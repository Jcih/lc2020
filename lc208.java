//https://www.youtube.com/watch?v=pkaooVBexeU
class TrieNode {
    char val;
    TrieNode[] children;
    boolean isWord;
    
    public TrieNode(char x) {
        children = new TrieNode[26];
        isWord = false;
        val = x;
    }
}

class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                //insert
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */






//

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