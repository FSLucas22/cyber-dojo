import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;

public class AnagramGeneratorImp implements AnagramGenerator {
    private final Swapper swapper;
    public AnagramGeneratorImp(Swapper swapper) {
        this.swapper = swapper;
    }
    private void addAnagramsWithFixedLetter(
            String word, Consumer<String> receiver) {
        var fixedLetter = word.charAt(0);
        var remainder = word.substring(1);
        var remainderAnagrams = new ArrayList<String>();

        generateAnagrams(remainder, remainderAnagrams::add);
        remainderAnagrams.forEach(anagram -> receiver.accept(fixedLetter + anagram));
    }
    @Override
    public void generateAnagrams(String word,
                                 Consumer<String> receiver) {
        Objects.requireNonNull(word, "A palavra não pode ser nula.");

        if (word.length() < 2) {
            receiver.accept(word);
            return;
        }

        addAnagramsWithFixedLetter(word, receiver);

        for (int i=1; i<word.length(); i++) {
            var tempWord = swapper.swap(word, i);
            addAnagramsWithFixedLetter(tempWord, receiver);
        }
    }
}
