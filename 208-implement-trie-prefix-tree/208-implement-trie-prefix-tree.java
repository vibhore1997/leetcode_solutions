class Trie {
TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++) {
            if (curr.hmap.containsKey(word.charAt(i))) {
                curr = curr.hmap.get(word.charAt(i));
            } else {
                TrieNode node = new TrieNode();
                curr.hmap.put(word.charAt(i), node);
                curr = node;
            }
        }
        curr.isWord = true;
    }
    
    private TrieNode searchPrefix(String word) {
        TrieNode curr = root;
        
        for(int i=0; i<word.length(); i++) {
            if (curr.hmap.containsKey(word.charAt(i))) {
                curr = curr.hmap.get(word.charAt(i));
            } else {
                return null;
            }
        }
        return curr;
    }
    
    public boolean search(String word) {
        TrieNode ans = searchPrefix(word);
        if (ans != null && ans.isWord) {
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode ans = searchPrefix(prefix);
        if (ans != null) {
            return true;
        }
        return false;
    }
}

public class TrieNode {
    public Map<Character, TrieNode> hmap;
    public boolean isWord;
    
    public TrieNode() {
        hmap = new HashMap<>();
        isWord = false;
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */