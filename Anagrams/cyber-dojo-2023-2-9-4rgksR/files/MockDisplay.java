public class MockDisplay extends Mock implements Display {
    @Override
    public void show(String word) {
        increaseCallCount("show");
    }
}