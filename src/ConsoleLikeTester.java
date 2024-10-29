import java.util.List;
import java.util.Scanner;

public class ConsoleLikeTester {
    private TxtFileRegister register;
    private Scanner scanner;

    public ConsoleLikeTester() {
        this.register = new TxtFileRegister();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        String choice;
        do {
            displayMenu();
            choice = scanner.next();
            scanner.nextLine();
            switch (choice) {
                case "1":
                    loadFolder();
                    break;
                case "2":
                    loadSpecificFile();
                    break;
                case "3":
                    searchWord();
                    break;
                case "4":
                    searchPrefix();
                    break;
                case "0":
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("0"));
    }

    private void displayMenu() {
        System.out.println("=== Console Like Tester ===");
        System.out.println("1. Load all txt files from folder");
        System.out.println("2. Load specific txt file");
        System.out.println("3. Search for a word in loaded files");
        System.out.println("4. Search for a prefix in loaded files");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private void loadFolder() {
        System.out.print("Enter the absolute path of the folder: ");
        String folderPath = scanner.nextLine();
        register.loadAllTxtFilesFromFolder(folderPath);
        System.out.println("Loaded all txt files from: " + folderPath);
    }

    private void loadSpecificFile() {
        System.out.print("Enter the absolute path of the txt file: ");
        String filePath = scanner.nextLine();
        register.loadSingleTxtFile(filePath);
        System.out.println("Loaded txt file: " + filePath);
    }

    private void searchWord() {
        System.out.print("Enter the word to search: ");
        String word = scanner.nextLine();
        List<String> foundFiles = register.searchWord(word);

        if (!foundFiles.isEmpty()) {
            System.out.println("The word '" + word + "' was found in the following files:");
            for (String fileName : foundFiles) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("The word '" + word + "' was not found in any loaded file.");
        }
    }

    private void searchPrefix() {
        System.out.print("Enter the prefix to search: ");
        String word = scanner.nextLine();
        List<String> foundFiles = register.searchPrefix(word);

        if (!foundFiles.isEmpty()) {
            System.out.println("The prefix '" + word + "' was found in the following files:");
            for (String fileName : foundFiles) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("The prefix '" + word + "' was not found in any loaded file.");
        }
    }

    public static void main(String[] args) {
        new ConsoleLikeTester().start();
    }
}
