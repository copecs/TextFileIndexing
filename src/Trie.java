import java.util.HashMap;
import java.util.Map;

public class Trie {
    private static class Node {
        public Map<Character, Node> nexts = new HashMap<>();
        public boolean isWord = false;

        public boolean hasChild(char c) {
            return nexts.containsKey(c);
        }

        public Node addChild(char c) {
            nexts.putIfAbsent(c, new Node());
            return nexts.get(c);
        }

        public Node goChild(char c) {
            return nexts.get(c);
        }

        public void markWord() {
            isWord = true;
        }
    }

    private final Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        word=word.toLowerCase();
        for (int i=0;i<word.length();i++) {
            char c  = word.charAt(i);
            if (!curr.hasChild(c)) {
                curr = curr.addChild(c);
            } else {
                curr = curr.goChild(c);
            }
        }
        curr.markWord();
    }

    private Node searchNode(String word){
        Node curr = root;
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.hasChild(c)) {
                return null;
            }
            curr = curr.goChild(c);
        }
        return curr;
    }

    public boolean search(String word) {
        Node curr = searchNode(word);
        return curr != null && curr.isWord;
    }

    public boolean searchPrefix(String word){
        Node curr = searchNode(word);
        return curr!=null;
    }

    public boolean searchWords(String[] words){
        for (String word: words){
            Node curr = searchNode(word);
            if(curr==null || !curr.isWord)
                return false;
        }
        return true;
    }

}
