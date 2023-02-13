import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class AnagramGeneratorImp implements AnagramGenerator {
    private final Swapper swapper;
    public AnagramGeneratorImp(Swapper swapper) {
        this.swapper = swapper;
    }
    private void addAnagramsWithFixedLetter(
            String word, Collection<String> receiver) {
        var fixedLetter = word.charAt(0);
        var remainder = word.substring(1);
        var remainderAnagrams = generateAnagrams(remainder, new ArrayList<>());
        for (String anagram : remainderAnagrams) {
            receiver.add(fixedLetter + anagram);
        }
    }
    @Override
    public Collection<String> generateAnagrams(String word,
                                               Collection<String> receiver) {
        Objects.requireNonNull(word, "A palavra não pode ser nula.");

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
