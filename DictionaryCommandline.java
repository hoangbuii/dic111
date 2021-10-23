import java.util.ArrayList;

public class DictionaryCommandline {
    public DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public DictionaryCommandline() {
        dictionaryManagement.insertFromFile();
    }

    /** Show Word in range 20. */
    public void showPageWord(int page) {
        ArrayList<Word> fullDictionary = dictionaryManagement.getDictionary().getWords();
        System.out.println("No\t|English\t|Type\t|Vietnamese");
        
        for (int i = (page - 1) * 20; i < (page - 1) * 20 + 20; i ++) {
            if (i < fullDictionary.size()) {
                String aWord = String.valueOf(i + 1) + "\t|" + fullDictionary.get(i).getWordTarget()
                + "\t|" + fullDictionary.get(i).getWordExplain();
                System.out.println(aWord);
            }
        }
    }

    /** Show all words to command line. */
    public void showAllWords() {//out
        System.out.println("No\t|English\t|Vietnamese");
        ArrayList<Word> fullDictionary = dictionaryManagement.getDictionary().getWords();
        for (int i = 0; i < fullDictionary.size(); i++) {
            String aWord = String.valueOf(i + 1) + "\t|" + fullDictionary.get(i).getWordTarget()
            + "\t|" + fullDictionary.get(i).getWordExplain();
            System.out.println(aWord);
        }
    }

    /** Look up and print */
    public Boolean lookupAWord(String target) {
        ArrayList<Word> fullDictionary = dictionaryManagement.getDictionary().getWords();
        int result = dictionaryManagement.lookupWord(target);
        if (result == -1) {
            System.out.println("This word is dose not exsit!");
            return false;
        } else {
            System.out.println("Result: ");
            System.out.println("\tTarget: " + target);
            System.out.println("\tExplain: " + fullDictionary.get(result).getWordExplain());
            return true;
        }
    }

    
    public void addAWord(String wordTarget, String wordExplain) {
        dictionaryManagement.addWord(wordTarget, wordExplain);
        dictionaryManagement.dictionaryExportToFile();
        dictionaryManagement.insertFromFile();
    }

    /** Read and show to command line. */
    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    /** Load from file and lookup. */
    public void dictionaryAdvanced() {
        dictionaryManagement.insertFromFile();
        showAllWords();
        dictionaryManagement.dictionaryLookup();
        dictionaryManagement.removeWord("Before");
        showAllWords();
        dictionaryManagement.dictionaryExportToFile();
    }

    /** Seach a word. */
    public ArrayList<Word> dictionarySearcher(String search) {
        ArrayList<Word> fullDictionary = dictionaryManagement.getDictionary().getWords();
        ArrayList<Word> searchs = new ArrayList<Word>();
        for (int i = 0; i < fullDictionary.size(); i++) {
            String wordTarget = fullDictionary.get(i).getWordTarget();
            if (search.equals(wordTarget.substring(0, search.length()))) {
                searchs.add(fullDictionary.get(i));
            }
        }
        return searchs;
    }

}
