import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;


public class AnagramGenerator {
    
    private void generateAnagramsWithFixedLetter(String word, Consumer<String> consumer) {
        var firstLetter = word.charAt(0);
        var otherLetters = word.substring(1);
        var otherAnagrams = generateAnagrams(otherLetters);
        otherAnagrams.forEach(anagram -> consumer.accept(firstLetter + anagram));
    }
    
    private String swapFirstLetter(String word, int otherLetterIndex) {
        var builder = new StringBuilder(word);
        var firstLetter = word.charAt(0);
        var otherLetter = word.charAt(otherLetterIndex);
        builder.setCharAt(0, otherLetter);
        builder.setCharAt(otherLetterIndex, firstLetter);
        return builder.toString();
    }
    
    public void generateAnagrams(String word, Consumer<String> consumer) {
        if (word.length() < 2) {
            consumer.accept(word);
            return;
        }
        
        generateAnagramsWithFixedLetter(word, consumer);
        var tempWord = word;
        for (int i=1; i<word.length(); i++) {
            tempWord = swapFirstLetter(word, i);
            generateAnagramsWithFixedLetter(tempWord, consumer);
        }
    }
    
    public List<String> generateAnagrams(String word) {
        var anagrams = new ArrayList<String>();
        generateAnagrams(word, anagrams::add);
        return anagrams;
    }
}
