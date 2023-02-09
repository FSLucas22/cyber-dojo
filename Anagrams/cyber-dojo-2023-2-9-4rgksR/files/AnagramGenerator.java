import java.util.List;
import java.util.ArrayList;
import java.util.Collection;


public interface AnagramGenerator {
    Collection<String> getAnagrams(String word, Collection<String> receiver);
        
    default List<String> getAnagrams(String word) {
        var permutations = getAnagrams(word, new ArrayList<String>());
        return new ArrayList<>(permutations);
    }
}
