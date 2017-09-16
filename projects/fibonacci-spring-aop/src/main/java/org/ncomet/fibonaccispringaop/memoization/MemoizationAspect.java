package org.ncomet.fibonaccispringaop.memoization;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class MemoizationAspect {

    private Map<Integer, Long> cache = new HashMap<>();

    @Pointcut("execution(long org.ncomet.fibonaccispringaop.service.FibonacciService.compute (int)) && args(n)")
    public void computeCallPointcut(int n) {
    }

    @Around("computeCallPointcut(n)")
    public long around(ProceedingJoinPoint joinPoint, int n) throws Throwable {
        if (cache.containsKey(n)) {
            System.out.println("****** cache HIT");
            return cache.get(n);
        } else {
            System.out.println("****** cache MISS");
            Long result = (Long) joinPoint.proceed(new Object[]{n});
            cache.put(n, result);
            return result;
        }
    }

}