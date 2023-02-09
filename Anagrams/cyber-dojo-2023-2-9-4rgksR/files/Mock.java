import java.util.Map;
import java.util.HashMap;

public abstract class Mock {
    private Map<String, Long> methodCalls = new HashMap<>();
    
    public long getCallCount(String methodName) {
        methodCalls.putIfAbsent(methodName, Long.valueOf(0));
        return methodCalls.get(methodName);
    }
    public void increaseCallCount(String methodName) {
        var callCount = getCallCount(methodName);
        methodCalls.put(methodName, Long.valueOf(callCount + 1));
    }
}