import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IndexOutOfBoundsException;
import java.util.Formatter;

public class DictionaryManagement {
    private Dictionary dictionary = new Dictionary();

    /** Insert from command line. */
    public void insertFromCommandline() {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        scan.nextLine();
        while (number != 0) {
            String wordTarget = scan.nextLine();
            String wordExplain = scan.nextLine();
            Word newWord = new Word(wordTarget, wordExplain);
            dictionary.addWord(newWord);
            number--;
        }
        scan.close();
    }

    /** Insert from File dictionaries. */
    public void insertFromFile() {
        try {
            File file = new File("dictionaries.txt");
            Scanner scan = new Scanner(file);
            dictionary.clear();
            while (scan.hasNextLine()) {
                String wordTarget = scan.next();
                String wordExplain = scan.next() + scan.nextLine();;
                Word newWord = new Word(wordTarget, wordExplain);
                dictionary.addWord(newWord);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file dose not exsit!");
        }
    }

    /** lookup a Word. */
    public int lookupWord(String word) {
        for (int i = 0; i < dictionary.sizeDictionary(); i++) {
            if (word.equals(dictionary.at(i).getWordTarget())) {
                return i;
            }
        }
        return -1;
    }

    /** Erease a word. */
    public void removeWord(String word) {
        try {
            dictionary.removeWord(lookupWord(word));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("This word does not exsit!");
        }
    }

    /** Change a word. */
    public void changeWord(String wordTarget, String wordExplain) {
        try {
            if (lookupWord(wordTarget) != -1) {
                dictionary.at(lookupWord(wordTarget)).setWordExplain(wordExplain);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("This word does not exsit!");
        }
    }

    /** Add a word. */
    public void addWord(String wordTarget, String wordExplain) {
        Word newWord = new Word(wordTarget, wordExplain);
        dictionary.addWord(newWord);
    }

    /** Search from dictionary. */
    public void dictionaryLookup() { //out
        Scanner scan = new Scanner(System.in);
        String lookup = scan.nextLine();
        try {
            System.out.println(dictionary.getWords().get(lookupWord(lookup)).getWordExplain());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("This word does not exsit!");
        }
        scan.close();
    }


    /** Export to file. */
    public void dictionaryExportToFile() {
        try {
            Formatter file = new Formatter("dictionaries.txt");
            for (int i = 0; i < dictionary.sizeDictionary(); i++) {
                String wordTarget = dictionary.at(i).getWordTarget();
                String wordExplain = dictionary.at(i).getWordExplain();
                file.format("%s\t%s", wordTarget, wordExplain + "\r\n");
            }
            file.close();
        } catch (Exception e) {
            System.out.println("The file dose not exsit!");
        }
    }

    /** Return dictionary.  */
    public Dictionary getDictionary() {
        return dictionary;
    }
}
