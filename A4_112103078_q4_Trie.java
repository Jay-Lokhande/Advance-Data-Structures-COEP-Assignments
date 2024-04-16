import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEndOfWord = true;
    }

    public String longestCommonPrefix() {
        StringBuilder prefix = new StringBuilder();
        TrieNode node = root;
        while (node.children.size() == 1 && !node.isEndOfWord) {
            char ch = node.children.keySet().iterator().next();
            prefix.append(ch);
            node = node.children.get(ch);
        }
        return prefix.toString();
    }
}

public class A4_112103078_q4_Trie {
    public static String longestCommonPrefix(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie.longestCommonPrefix();
    }

    public static void main(String[] args) {
        String[] words = {"Cancellation", "Cancel", "Canada", "Canabary", "Can", "Cando"};
        System.out.println("Longest common prefix: " + longestCommonPrefix(words));
    }
}
