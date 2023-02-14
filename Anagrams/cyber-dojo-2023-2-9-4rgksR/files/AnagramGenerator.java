import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface AnagramGenerator {
    void generateAnagrams(String word, Consumer<String> receiver);

    default List<String> generateAnagrams(String word) {
        var permutations = new ArrayList<String>();
        generateAnagrams(word, permutations::add);
        return permutations;
    }
}
