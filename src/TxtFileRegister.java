import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TxtFileRegister {
    private List<TxtFile> txtFiles;

    public TxtFileRegister() {
        this.txtFiles = new ArrayList<>();
    }

    public void addTxtFile(String filePath) {
        try {
            TxtFile txtFile = new TxtFile(filePath);
            txtFiles.add(txtFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }

    public void loadAllTxtFilesFromFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files != null) {
            for (File file : files) {
                addTxtFile(file.getAbsolutePath());
            }
        } else {
            System.out.println("No .txt files found in the folder: " + folderPath);
        }
    }

    public void loadSingleTxtFile(String filePath) {
        addTxtFile(filePath);
    }

    public List<String> searchWord(String word) {
        List<String> filepaths = new ArrayList<>();
        for (TxtFile txtFile : txtFiles) {
            if (txtFile.searchWord(word)) {
                filepaths.add(txtFile.getFilePath());
            }
        }

        return filepaths;
    }
    public List<String> searchPrefix(String word){
        List<String> filepaths = new ArrayList<>();
        for (TxtFile txtFile : txtFiles) {
            if (txtFile.searchPrefix(word)) {
                filepaths.add(txtFile.getFilePath());
            }
        }
        return filepaths;
    }

}
