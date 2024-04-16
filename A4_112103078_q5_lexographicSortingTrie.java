import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TreeMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

    void traverse(TrieNode node, StringBuilder sb, List<String> result) {
        if (node.isEndOfWord) {
            result.add(sb.toString());
        }
        for (char c : node.children.keySet()) {
            sb.append(c);
            traverse(node.children.get(c), sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    List<String> getSortedWords() {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        traverse(root, sb, result);
        return result;
    }
}

public class A4_112103078_q5_lexographicSortingTrie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter words (type 'done' when finished):");
        Trie trie = new Trie();
        while (true) {
            String word = scanner.nextLine().trim();
            if (word.equals("done")) {
                break;
            }
            trie.insert(word);
        }
        List<String> sortedWords = trie.getSortedWords();
        System.out.println("Result:");
        for (String word : sortedWords) {
            System.out.println(word);
        }
        scanner.close();
    }
}
