public class Anagrams {
    private AnagramGenerator generator;
    private Display display;
    public Anagrams(AnagramGenerator generator, Display display) {
        this.generator = generator;
        this.display = display;
    }
    public void showAnagrams(String word) {
        var anagrams = generator.getAnagrams(word);
        anagrams.forEach(
            anagram -> display.show(anagram)
        );
    }
}
