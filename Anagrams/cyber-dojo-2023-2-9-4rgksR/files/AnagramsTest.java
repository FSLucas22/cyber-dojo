import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


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
        var permutations = generator.getAnagrams(word);
        anagrams.showAnagrams(word);
        assertEquals(permutations.size(), display.getCallCount("show"));
    }
    @Test
    void should_display_all_anagrams() {
        anagrams = new Anagrams(generator, System.out::println);
        anagrams.showAnagrams(word);
    }
}