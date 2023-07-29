package leetCode;
class TrieNode {
    public boolean isEnd;
    TrieNode[] node;

    public TrieNode() {
        node = new TrieNode[26];
    }

    public void put(char c, TrieNode node) {
        this.node[c - 'a'] = node;
    }

    public TrieNode get(char c) {
        return this.node[c - 'a'];
    }

    public boolean containsKey(char c) {
        return this.node[c - 'a'] != null;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public TrieNode serachPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = serachPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = serachPrefix(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 * 
 * public static void main(String[] args) {
 * Trie tNode = new Trie();
 * tNode.insert("apple");
 * System.out.println(tNode.search("apple"));
 * }
 */