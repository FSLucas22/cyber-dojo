import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;


public interface AnagramGenerator {
    Collection<String> generateAnagrams(String word, Collection<String> receiver);

    default List<String> generateAnagrams(String word) {

        Objects.requireNonNull(word, "A palavra não pode ser nula.");

        if (word.isEmpty()) {
            throw new IllegalArgumentException("A palavra não pode ser vazia ou nula.");
        }

        var permutations = generateAnagrams(word, new ArrayList<>());
        return new ArrayList<>(permutations);
    }
}
