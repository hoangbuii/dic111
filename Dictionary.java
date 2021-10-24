import java.util.ArrayList;

public class Dictionary {
    //ArrayLists storage words
    private ArrayList<Word> words = new ArrayList<Word>();

    /** Get words. */
    public ArrayList<Word> getWords() {
        return words;
    }

    /** Add word to dictionary. */
    public void addWord(Word newWord) {
        words.add(newWord);
    }

    /** Remove word from dictionary. */
    public void removeWord(int index) {
        if (index >= 0 && index < words.size()) {
            words.remove(index);
        }
    }

    /** Return size. */
    public int sizeDictionary() {
        return words.size();
    }

    /** Return Word at index. */
    public Word at(int index) {
        if (index >= 0) {
            return words.get(index);
        }
        return null;
    }

    /** Clear dictionary. */
    public void clear() {
        words.clear();
    }
}
