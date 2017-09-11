package memoization;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import static net.bytebuddy.implementation.MethodDelegation.to;
import static net.bytebuddy.matcher.ElementMatchers.named;

public class Memoization {

    private static Map<Integer, Long> cache;

    public Memoization() {
        this.cache = new HashMap<>();
    }

    public <T> T of(Class<T> type) {
        try {
            return new ByteBuddy()
                    .subclass(type)
                    .method(named("compute"))
                    .intercept(to(this))
                    .make()
                    .load(type.getClassLoader())
                    .getLoaded()
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public long intercept(int arg, @SuperCall Callable<Long> superMethod) throws Exception {
        return cache.computeIfAbsent(arg, o -> {
            try {
                return superMethod.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0L;
        });
    }

}
