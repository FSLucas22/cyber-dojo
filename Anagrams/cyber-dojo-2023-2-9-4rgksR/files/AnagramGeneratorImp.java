import java.util.ArrayList;
import java.util.Collection;


public class AnagramGeneratorImp implements AnagramGenerator {
    private final Swapper swapper;
    public AnagramGeneratorImp(Swapper swapper) {
        this.swapper = swapper;
    }
    private void addAnagramsWithFixedLetter(
    String word, Collection<String> receiver) {
        var fixedLetter = word.charAt(0);
        var remainder = word.substring(1);
        var remainderAnagrams = getAnagrams(remainder, new ArrayList<String>());
        for (String anagram : remainderAnagrams) {
            receiver.add(fixedLetter + anagram);
        }
    }
    @Override
    public Collection<String> getAnagrams(String word,
                                          Collection<String> receiver) {
        if (word.length() < 2) {
            receiver.add(word);
            return receiver;
        }
        
        addAnagramsWithFixedLetter(word, receiver);
        var tempWord = word;
        for (int i=1; i<word.length(); i++) {
            tempWord = swapper.swap(word, i);
            addAnagramsWithFixedLetter(tempWord, receiver);
        }
        return receiver;
    }
}
