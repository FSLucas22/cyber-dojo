public class Anagrams {
    private final AnagramGenerator generator;
    private final Display display;
    public Anagrams(AnagramGenerator generator, Display display) {
        this.generator = generator;
        this.display = display;
    }
    public void showAnagrams(String word) {
        var anagrams = generator.generateAllAnagrams(word);
        anagrams.forEach(display::show);
    }
}
