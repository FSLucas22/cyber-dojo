public class Counter {
    private Converter converter;
    private Display display;
    
    public Counter(Converter converter, Display display) {
        this.converter = converter;
        this.display = display;
    }
    
    public void count(int toNumber) {
        for (int i=0; i<toNumber; i++) {
            display.show(converter.convert(i+1));
        }
    }
}