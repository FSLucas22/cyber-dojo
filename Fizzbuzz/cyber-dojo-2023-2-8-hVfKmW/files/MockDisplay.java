import java.util.List;
import java.util.ArrayList;

public class MockDisplay implements Display {
    private int displayCount = 0;
    private List<String> valuesDisplayed = new ArrayList<>();
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