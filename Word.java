public class Word {
    private String wordTarget;
    private String wordExplain;

    /** Constructor. */
    public Word(String wordTarget, String wordExplain) {
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
    }
    
    /** Get Word Target. */
    public String getWordTarget() {
        return wordTarget;
    }

    /** Set Word Target. */
    public void setWordTarget(String wordTarget) {
        this.wordTarget = wordTarget;
    }
    
    /** Get Word Explain. */
    public String getWordExplain() {
        return wordExplain;
    }

    /** Set Word Explain. */
    public void setWordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }
}