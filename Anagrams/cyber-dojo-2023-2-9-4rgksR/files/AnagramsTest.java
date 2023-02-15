import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AnagramsTest {
    private Anagrams anagrams;
    private MockDisplay display;
    private AnagramGenerator generator;
    private String word;
    @BeforeEach
    public void setup() {
        word = "biro";
        display = new MockDisplay();
        generator = new AnagramGeneratorImp(new SwapperImp());
        anagrams = new Anagrams(generator, display);
    }

    @Test
    void should_display_all_anagrams_of_generator() {
        List<String> anagramsList = new ArrayList<>();
        Consumer<String> receiver = anagramsList::add;
        generator.generateAllAnagrams(word, receiver);
        anagrams.showAnagrams(word);
        Assertions.assertEquals(anagramsList.size(), display.getCallCount("show"));
    }
    @Test
    void should_display_all_anagrams() {
        anagrams = new Anagrams(generator, System.out::println);
        anagrams.showAnagrams(word);
    }
}