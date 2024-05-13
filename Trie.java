import java.util.*;

public class Trie {

    // Non-primitive implementation of Trie
    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.containsKey(ch)) {
                    node = node.get(ch);
                } else {
                    return null;
                }
            }
            return node;
        }

        static class TrieNode {
            private TrieNode[] links;
            private final int R = 26;
            private boolean isEnd;

            public TrieNode() {
                links = new TrieNode[R];
            }

            public boolean containsKey(char ch) {
                return links[ch - 'a'] != null;
            }

            public TrieNode get(char ch) {
                return links[ch - 'a'];
            }

            public void put(char ch, TrieNode node) {
                links[ch - 'a'] = node;
            }

            public void setEnd() {
                isEnd = true;
            }

            public boolean isEnd() {
                return isEnd;
            }
        }
    }

    // Primitive implementation of Trie
    static class PrimitiveTrie {
        private static final int ALPHABET_SIZE = 26;
        private TrieNode root;

        public PrimitiveTrie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }

        static class TrieNode {
            TrieNode[] children;
            boolean isEndOfWord;

            TrieNode() {
                children = new TrieNode[ALPHABET_SIZE];
            }
        }
    }

    public static void main(String[] args) {
        // Non-primitive Trie
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("Search 'apple': " + trie.search("apple"));
        System.out.println("Search 'app': " + trie.search("app"));
        System.out.println("Starts with 'app': " + trie.startsWith("app"));

        // Primitive Trie
        PrimitiveTrie primitiveTrie = new PrimitiveTrie();
        primitiveTrie.insert("apple");
        System.out.println("Search 'apple': " + primitiveTrie.search("apple"));
        System.out.println("Search 'app': " + primitiveTrie.search("app"));
        System.out.println("Starts with 'app': " + primitiveTrie.startsWith("app"));
    }
}
