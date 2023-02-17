import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


class AnagramIteratorTest {

    @Test
    void shouldHaveNext() {
        var iterator = new AnagramIterator("biro");
        assertTrue(iterator.hasNext());
    }
    
    @Test
    void shouldNotAcceptNull() {
        assertThrows(NullPointerException.class,
                     () -> new AnagramIterator(null)
        );
    }
    
    @Test
    void shouldReturnWordOnNext() {
        // Given
        var iterator = new AnagramIterator("x");
        // When
        var returned = iterator.next();
        // Then
        assertEquals("x", returned);
    }
    
    @Test
    void shouldNotHaveNextAfterNextWasCalled() {
        // Given
        var iterator0 = new AnagramIterator("");
        var iterator1 = new AnagramIterator("x");
        // When
        iterator0.next();
        iterator1.next();
        // Then
        assertFalse(iterator0.hasNext());
        assertFalse(iterator1.hasNext());
    }
    
    @Test
    void shouldHaveNextAfterNextOnce() {
        // Given
        var iterator = new AnagramIterator("ab");
        // When
        iterator.next();
        // Then
        assertTrue(iterator.hasNext());
    }
    
    @Test
    void shouldReturnWordAndReversedWord() {
        // Given
        var anagrams = new ArrayList<String>();
        var iterator = new AnagramIterator("biro");
        // When
        iterator.forEachRemaining(anagrams::add);
        // Then
        assertTrue(anagrams.contains("biro"));
        assertTrue(anagrams.contains("orib"));
    }
    
    @Test
    void shouldContainWordStartingWithSecondLetter() {
        // Given
        var word = "abc";
        var iterator = new AnagramIterator(word);
        var anagrams = new ArrayList<String>();
        // When
        iterator.forEachRemaining(anagrams::add);
        // Then
        assertTrue(anagrams.contains("bac") || anagrams.contains("bca"));
    }
    
    @Test
    void shouldContainAllAnagramsStatingWithSecondLetter() {
        // Given
        var word = "abc";
        var iterator = new AnagramIterator(word);
        var anagrams = new ArrayList<String>();
        // When
        iterator.forEachRemaining(anagrams::add);
        // Then
        assertTrue(anagrams.contains("bac"));
        assertTrue(anagrams.contains("bca"));
    }
    
    @Test
    void shouldContainAllAnagramsStartigWithFirstLetter() {
        // Given
        var word = "abc";
        var iterator = new AnagramIterator(word);
        var anagrams = new ArrayList<String>();
        // When 
        iterator.forEachRemaining(anagrams::add);
        // Then 
        assertTrue(anagrams.contains("abc"));
        assertTrue(anagrams.contains("acb"));
    }
    
    @Test
    void shouldContainAllAnagramsStartingWithThirdLetter() {
        // Given
        var word = "abc";
        var iterator = new AnagramIterator(word);
        var anagrams = new ArrayList<String>();
        // When
        iterator.forEachRemaining(anagrams::add);
        // Then
        assertTrue(anagrams.contains("cab"));
        assertTrue(anagrams.contains("cba"));
    }
}
