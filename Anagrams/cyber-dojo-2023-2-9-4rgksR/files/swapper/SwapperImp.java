public class SwapperImp implements Swapper {
    @Override
    public String swap(String word, int firstIndex, int lastIndex) {
        StringBuilder builder = new StringBuilder(word);
        var firstChar = word.charAt(firstIndex);
        var lastChar = word.charAt(lastIndex);
        builder.setCharAt(firstIndex, lastChar);
        builder.setCharAt(lastIndex, firstChar);
        return builder.toString();
    }
}
