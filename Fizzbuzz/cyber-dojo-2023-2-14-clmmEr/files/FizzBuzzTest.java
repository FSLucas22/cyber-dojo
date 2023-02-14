import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.TreeMap;
import java.util.Map;


class FizzBuzzTest {
    private final String wordForMultipleOfThree = "Fizz";
    private final String wordForMultipleOfFive = "Buzz";
    
    private FizzBuzz fizzbuzz;
    
    @BeforeEach
    public void setup() {
        Map<Integer, String> divisors = new TreeMap<>();
        divisors.put(3, wordForMultipleOfThree);
        divisors.put(5, wordForMultipleOfFive);
        fizzbuzz = new FizzBuzz(divisors);
    }

    @Test
    void test_should_return_value_as_string() {
        String value = fizzbuzz.convert(1);
        assertEquals("1", value);
    }
    
    @Test
    void test_should_return_fizz_on_three() {
        String value = fizzbuzz.convert(3);
        var expected = wordForMultipleOfThree;
        assertEquals(expected, value);
    }
    
    @Test
    void test_should_return_buzz_on_five() {
        String value = fizzbuzz.convert(5);
        var expected = wordForMultipleOfFive;
        assertEquals(expected, value);
    }
    
    @Test
    void test_should_return_fizz_on_multiples_of_three() {
        String value = fizzbuzz.convert(6);
        var expected = wordForMultipleOfThree;
        assertEquals(expected, value);
    }
    
    @Test
    void test_should_return_buzz_on_multiples_of_five() {
        String value = fizzbuzz.convert(10);
        var expected = wordForMultipleOfFive;
        assertEquals(expected, value);
    }
    
    @Test
    void test_should_return_fizzbuzz_on_multiples_of_three_and_five() {
        String value = fizzbuzz.convert(30);
        var expected = wordForMultipleOfThree + wordForMultipleOfFive;
        assertEquals(expected, value);
    }
}
