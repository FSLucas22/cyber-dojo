import java.util.Iterator;


public class AnagramGenerator implements Iterable<String> {
    private String word;
    public AnagramGenerator(String word) {
        this.word = word;
    }
    
    @Override
    public Iterator<String> iterator() {
        return new AnagramIterator(word);
    }
}