import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface AnagramGenerator {
    Collection<String> generateAnagrams(String word, Collection<String> receiver);

    default List<String> generateAnagrams(String word) {
        var permutations = generateAnagrams(word, new ArrayList<>());
        return new ArrayList<>(permutations);
    }
}
