package memoization;

import fibonacci.Fibonacci;

import java.util.HashMap;
import java.util.Map;

public aspect MemoizationAspect {

    private Map<Integer, Long> cache = new HashMap<>();

    pointcut callToCompute(int n, Fibonacci fibonacci) :
            call(long Fibonacci.compute(int)) && args(n) && target(fibonacci);

    long around(int n, Fibonacci fibonacci): callToCompute(n, fibonacci) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            long result = proceed(n, fibonacci);
            cache.put(n, result);
            return result;
        }
    }

}