import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TxtFile {
    private File file;
    private Trie trie;
    private String filepath;

    public TxtFile(String filePath) throws FileNotFoundException {
        this.file = new File(filePath);
        filepath=filePath;
        this.trie = new Trie();
        makeTrie();
    }

    public String getFilePath(){
        return filepath;
    }

    private void makeTrie() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String word = scanner.next().replaceAll("[^a-zA-Z]", "").toLowerCase();
            trie.insert(word);
        }
        scanner.close();
    }

    public boolean searchWord(String word) {
        return trie.search(word);
    }
    public boolean searchPrefix(String word) {
        return trie.searchPrefix(word);
    }
    public boolean searchWords(String[] words){
        return trie.searchWords(words);
    }

}
