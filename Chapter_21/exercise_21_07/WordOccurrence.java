package exercise_21_07;

public class WordOccurrence implements Comparable<WordOccurrence> {
    private String word;
    private Integer count;

    public WordOccurrence(String word, Integer count) {
        this.word = word;
        this.count = count;
    }
    
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    @Override
    public int compareTo(WordOccurrence w) {
        return getCount().compareTo(w.getCount());
    }
    
    @Override
    public String toString() {
        return getWord() + "\t" + getCount();
    }
    
}
