import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;


public class AnagramGeneratorImpTest {
    private MockSwapper swapper;
    private AnagramGenerator generator;
    @BeforeEach
    public void setup(){
        swapper = new MockSwapper();
        generator = new AnagramGeneratorImp(swapper);
    }
    @Test
    void test_should_have_size_one_with_single_letter() {
        assertEquals(1, generator.getAnagrams("a").size());
    }
    @Test
    void test_should_call_swapper_once() {
        var word = "ab";
        generator.getAnagrams(word);
        assertEquals(1, swapper.getCallCount("swap"));
    }
    @Test
    void test_should_have_factorial_elements() {
        var word = "abc";
        var permutations = generator.getAnagrams(word);
        assertEquals(6, permutations.size());
    }
    @Test
    void test_should_call_swapper_factorial_minus_one_times() {
        var word = "abc";
        generator.getAnagrams(word);
        assertEquals(5, swapper.getCallCount("swap"));
    }
    @Test
    void test_should_contain_original_word() {
        var word = "biro";
        assertTrue(generator.getAnagrams(word).contains(word));
    }
}