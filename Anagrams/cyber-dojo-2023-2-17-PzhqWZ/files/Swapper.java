class Swapper {
    public static String swap(String word, int index) {
        if (word.length() < 2) {
            return word;
        }
        var builder = new StringBuilder(word);
        builder.setCharAt(0, word.charAt(index));
        builder.setCharAt(index, word.charAt(0));
        return builder.toString();
    }
}