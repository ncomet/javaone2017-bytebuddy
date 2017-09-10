package fibonacci;

import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.testng.Assert.*;

public class FibonacciTest {

    @Test
    public void fiboTime() throws Exception {
        long start = System.nanoTime();
        Fibonacci fibonacci = new Fibonacci();
        long fibo = fibonacci.compute(42);
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}