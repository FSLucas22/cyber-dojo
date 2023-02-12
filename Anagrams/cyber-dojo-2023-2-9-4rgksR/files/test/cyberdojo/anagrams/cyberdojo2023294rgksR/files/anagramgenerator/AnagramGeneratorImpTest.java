package test.cyberdojo.anagrams.cyberdojo2023294rgksR.files;

import anagramgenerator.AnagramGenerator;
import anagramgenerator.AnagramGeneratorImp;
import mocks.MockSwapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
        AtomicInteger count = new AtomicInteger();
        generator.generateAnagrams("a", s -> count.getAndIncrement());
        assertEquals(1, count.get());
    }

    @Test
    void test_should_call_swapper_once() {
        var word = "ab";
        generator.generateAnagrams(word, s -> {});
        Assertions.assertEquals(1, swapper.getCallCount("swap"));
    }

    @Test
    void test_should_have_factorial_elements() {
        var word = "abc";
        AtomicInteger count = new AtomicInteger();
        generator.generateAnagrams(word, s -> count.getAndIncrement());
        assertEquals(6, count.get());
    }

    @Test
    void test_should_call_swapper_factorial_minus_one_times() {
        var word = "abc";
        generator.generateAnagrams(word, s -> {});
        Assertions.assertEquals(5, swapper.getCallCount("swap"));
    }

    @Test
    void test_should_contain_original_word() {
        var word = "biro";
        AtomicBoolean containsOriginal = new AtomicBoolean(false);
        generator.generateAnagrams(word, s -> {
            if (s.equals(word)) {
                containsOriginal.set(true);
            }
        });
        assertTrue(containsOriginal.get());
    }
}