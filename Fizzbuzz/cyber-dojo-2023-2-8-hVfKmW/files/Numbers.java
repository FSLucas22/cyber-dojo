public class Numbers {
    private final Display display;
    public Numbers(Display display) {
        this.display = display;
    }
    public void showNumbers(int count) {
        for (int i=1; i<=count; i++) {
            String value = Fizzbuzz.convertValue(i);
            this.display.show(value);
        }
    }
}