import java.util.HashMap;
import java.util.Map;

public abstract class Mock {
    private final Map<String, Long> methodCalls = new HashMap<>();

    public long getCallCount(String methodName) {
        methodCalls.putIfAbsent(methodName, 0L);
        return methodCalls.get(methodName);
    }
    public void increaseCallCount(String methodName) {
        var callCount = getCallCount(methodName);
        methodCalls.put(methodName, callCount + 1);
    }
}