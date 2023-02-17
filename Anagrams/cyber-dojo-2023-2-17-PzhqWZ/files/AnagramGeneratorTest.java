import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class AnagramGeneratorTest {
    @Test
    void shouldShowAllAnagrams() {
        var word = "biro";
        var generator = new AnagramGenerator(word);
        generator.forEach(System.out::println);
    }
}