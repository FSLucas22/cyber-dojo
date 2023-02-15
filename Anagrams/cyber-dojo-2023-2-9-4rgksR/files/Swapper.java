public interface Swapper {
    String swap(String word, int firstIndex, int lastIndex);

    default String swap(String word, int index) {
        return swap(word, 0, index);
    }
}