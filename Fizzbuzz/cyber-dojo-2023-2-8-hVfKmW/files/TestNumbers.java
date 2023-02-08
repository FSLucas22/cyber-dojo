import org.junit.Before;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TestNumbers {
    private MockDisplay display;
    private Numbers numbers;
    
    @BeforeEach
    public void setupBefore() {
        this.display = new MockDisplay();
        this.numbers = new Numbers(display);
    }
    
    @Test
    public void test_should_call_display_two_times() {
        numbers.showNumbers(2);
        assertEquals(display.getDisplayCount(), 2);
    }
    
    @Test
    public void test_should_call_display_with_values_from_fizzbuzz() {
        numbers.showNumbers(3);
        assertEquals(List.of("1", "2", "Fizz"), display.getValuesDisplayed());
    }
}