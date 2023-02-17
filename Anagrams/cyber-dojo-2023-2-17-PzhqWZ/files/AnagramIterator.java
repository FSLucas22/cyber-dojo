import java.util.Iterator;
import java.util.Objects;


class AnagramIterator implements Iterator<String> {
    private String originalWord;
    private String currentWord;
    private int remaining;
    private AnagramIterator subAnagramIterator;
    
    public AnagramIterator(String word) {
        Objects.requireNonNull(word,
                               "word cannot be null");
        this.originalWord = word;
        this.remaining = word.length();
    }
    
    private void setSubAnagramIterator() {
        var remainingWord = currentWord.substring(1);
        subAnagramIterator = new AnagramIterator(remainingWord);
    }
    
    @Override
    public boolean hasNext() {
        if (remaining > 0) {
            return true;
        }
        return (subAnagramIterator != null) && subAnagramIterator.hasNext();
    }
    
    @Override
    public String next() {
        if (originalWord.length() < 2) {
            remaining--;
            return originalWord;
        }
        if (subAnagramIterator == null) {
            currentWord = originalWord;
            setSubAnagramIterator();
            remaining--;
        }
        if (!subAnagramIterator.hasNext()) {
            currentWord = Swapper.swap(originalWord, originalWord.length() - remaining);
            setSubAnagramIterator();
            remaining--;
        }
        var firstLetter = currentWord.charAt(0);
        return firstLetter + subAnagramIterator.next();
    }
}
