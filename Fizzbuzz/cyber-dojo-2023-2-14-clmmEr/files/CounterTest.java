import org.junit.jupiter.api.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import java.util.TreeMap;
import java.util.Map;


@ExtendWith(MockitoExtension.class)
public class CounterTest {
    
    @Mock
    private Converter converter;
    
    @Mock
    private Display display;
    
    private Counter counter;
    
    @BeforeEach
    public void setup() {
        lenient().when(
            converter.convert(anyInt())
        ).thenReturn("x");
        
        lenient().doNothing().when(display).show(anyString());
        
        counter = new Counter(converter, display);
    }
    
    @Test
    void should_call_the_converter_two_times() {
        int toNumber = 2;
        counter.count(toNumber);
        
        verify(converter, times(toNumber)).convert(anyInt());
    }
    
    @Test
    void test_should_call_the_display() {
        counter.count(2);
        verify(display, atLeastOnce()).show(anyString());
    }
    
    @Test
    void test_should_show_numbers() {
        var rules = new TreeMap<Integer, String>(Map.of(3, "Fizz", 5, "Buzz"));
        var counter = new Counter(new FizzBuzz(rules), System.out::println);
        counter.count(100);
    }
}
