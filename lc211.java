class WordDictionary {
    
    
    
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.nexts[c - 'a'] == null)
                p.nexts[c - 'a'] = new TrieNode();
            p = p.nexts[c - 'a'];
        }
        p.val = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        
        return searchWord(word, 0, root);
    }
    
    
    private boolean searchWord(String word, int index, TrieNode p) {
        if (p == null)
            return false;
        if (index == word.length())
            return p.val != null;
        
        if (word.charAt(index) == '.') {
            for (TrieNode next : p.nexts) {
                if (searchWord(word, index + 1, next))
                    return true;
            }
        } else {
            return searchWord(word, index + 1, p.nexts[word.charAt(index) - 'a']);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

class TrieNode {
    String val;
    TrieNode[] nexts;
    
    public TrieNode() {
        nexts = new TrieNode[26];
    }
}