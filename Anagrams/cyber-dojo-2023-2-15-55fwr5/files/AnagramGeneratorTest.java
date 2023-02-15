import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

class AnagramGeneratorTest {
    
    private AnagramGenerator generator;
    
    @BeforeEach
    public void setup() {
        generator = new AnagramGenerator();
    }
    
    @Test
    void test_should_return_list_with_same_letter_for_single_letter() {
        List<String> anagrams = generator.generateAnagrams("a");
        var expected = List.of("a");
        assertEquals(expected, anagrams);
    }
    
    @Test
    void test_should_have_two_elements_for_two_letters() {
        var anagrams = generator.generateAnagrams("ab");
        assertEquals(2, anagrams.size());
    }
    
    @Test
    void test_should_return_list_with_same_word_for_empty_word() {
        var anagrams = generator.generateAnagrams("");
        var expected = List.of("");
        assertEquals(expected, anagrams);
    }
    
    @Test
    void test_should_contain_reversed_word() {
        var anagrams = generator.generateAnagrams("biro");
        assertTrue(anagrams.contains("orib"));
    }
    
    @Test
    void test_should_contain_all_anagrams_starting_with_first_letter() {
        var word = "abc";
        var anagrams = generator.generateAnagrams(word);
        assertTrue(anagrams.contains("abc"));
        assertTrue(anagrams.contains("acb"));
    }
    
    @Test
    void test_should_contain_all_anagrams_starting_with_second_letter() {
        var word = "abc";
        var anagrams = generator.generateAnagrams(word);
        assertTrue(anagrams.contains("bac"));
        assertTrue(anagrams.contains("bca"));
    }
    
    @Test
    void test_should_countain_all_anagrams_starting_with_last_letter() {
        var word = "abc";
        var anagrams = generator.generateAnagrams(word);
        assertTrue(anagrams.contains("cab"));
        assertTrue(anagrams.contains("cba"));
    }
    
    @Test
    void test_should_display_all_anagrams() {
        var word = "biro";
        generator.generateAnagrams(word, System.out::println);
    }
}
