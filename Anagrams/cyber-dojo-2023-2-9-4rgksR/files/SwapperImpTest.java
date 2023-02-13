import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwapperImpTest {
    private Swapper swapper;
    @BeforeEach
    public void setup() {
        swapper = new SwapperImp();
    }
    @Test
    void test_should_return_different_element() {
        var word = "ab";
        assertNotEquals(word, swapper.swap(word, 1));
    }
    @Test
    void test_should_return_element_with_equal_length() {
        var word = "ab";
        var permutation = swapper.swap(word, 1);
        assertEquals(word.length(), permutation.length());
    }
    @Test
    void test_should_return_element_with_same_letters() {
        var permutation = swapper.swap("ab", 1);
        assertTrue(
                permutation.contains("a") && permutation.contains("b")
        );
    }
    @Test
    void test_should_return_same_word_with_index_zero() {
        var word = "biro";
        assertEquals(word, swapper.swap(word, 0));
    }
    @Test
    void test_should_swap_first_letter_and_letter_in_index() {
        var word = "biro";
        var result = swapper.swap(word, 2);
        assertEquals("ribo", result);
    }
    @Test
    void test_should_swap_letters_in_indexes() {
        var word = "biro";
        var result = swapper.swap(word, 1, 2);
        assertEquals("brio", result);
    }
}
