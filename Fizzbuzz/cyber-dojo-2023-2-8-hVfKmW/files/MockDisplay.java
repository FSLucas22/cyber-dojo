import java.util.ArrayList;
import java.util.List;

public class MockDisplay implements Display {
    private int displayCount = 0;
    private final List<String> valuesDisplayed = new ArrayList<>();
    public void show(String value) {
        displayCount++;
        valuesDisplayed.add(value);
    }
    public int getDisplayCount() {
        return displayCount;
    }
    public List<String> getValuesDisplayed() {
        return new ArrayList<>(valuesDisplayed);
    }
}