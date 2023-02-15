import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface AnagramGenerator {
    void generateAllAnagrams(String word, Consumer<String> receiver);

    default List<String> generateAllAnagrams(String word) {
        var permutations = new ArrayList<String>();
        generateAllAnagrams(word, permutations::add);
        return permutations;
    }
}
