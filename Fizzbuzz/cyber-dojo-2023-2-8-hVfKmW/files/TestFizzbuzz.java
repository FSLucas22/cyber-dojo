import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FizzbuzzTest {
    
    @Test
    public void test_convertValue_returns_same_value_on_non_multiples_of_three_or_five() {
        int[] cases = {1, 2, 7, 53};
        String[] expected = {"1", "2", "7", "53"};
        
        for (int i=0; i < cases.length; i++) {;
            assertEquals(expected[i],Fizzbuzz.convertValue(cases[i]));
        }
    }
    
    @Test
    public void test_convertValue_returns_fizz_on_multiples_of_three_not_five() {
        int[] cases = {3, 9, 12};
        String expected = "Fizz";
        
        for (int i=0; i < cases.length; i++) {;
            assertEquals(expected,Fizzbuzz.convertValue(cases[i]));
        }
    }
    
    @Test
    public void test_convertValue_returns_buzz_on_multiples_of_five_not_three() {
        int[] cases = {5, 10, 20};
        String expected = "Buzz";
        
        for (int i=0; i < cases.length; i++) {;
            assertEquals(expected,Fizzbuzz.convertValue(cases[i]));
        }
    }
    
    @Test
    public void test_convertValue_returns_fizzbuzz_on_multiples_of_three_and_five() {
        int[] cases = {0, 15, 30};
        String expected = "FizzBuzz";
        
        for (int i=0; i < cases.length; i++) {;
            assertEquals(expected,Fizzbuzz.convertValue(cases[i]));
        }
    }
}    