import java.util.Map;


public class FizzBuzz implements Converter {
    private Map<Integer, String> divisors;
    
    public FizzBuzz(Map<Integer, String> divisors) {
        this.divisors = divisors;
    }
    
    public String convert(int value) {
        var result = "";
        
        for (Integer number : divisors.keySet()) {
            if (value % number == 0) {
                result += divisors.get(number);
            }
        }

        if (result == "") {
            result = Integer.toString(value);
        }
        return result;
    }
}
