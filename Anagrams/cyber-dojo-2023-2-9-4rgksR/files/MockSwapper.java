public class MockSwapper extends Mock implements Swapper {
    @Override
    public String swap(String word, int firstIndex, int lastIndex) {
        increaseCallCount("swap");
        return word;
    }
}
