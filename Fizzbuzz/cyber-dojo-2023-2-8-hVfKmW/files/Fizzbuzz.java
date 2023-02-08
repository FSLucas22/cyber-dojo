public class Fizzbuzz {
    public static String convertValue(int value) {
        String result = Integer.toString(value);
        if (value % 15 == 0) {
            result = "FizzBuzz";
        } else if (value % 3 == 0) {
            result = "Fizz";
        } else if (value % 5 == 0) {
            result = "Buzz";
        }
        return result;
    }
}