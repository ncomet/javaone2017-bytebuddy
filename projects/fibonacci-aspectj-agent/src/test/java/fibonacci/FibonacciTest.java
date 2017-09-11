package fibonacci;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class FibonacciTest {

    private long total = 0L;

    @Test(invocationCount = 50)
    public void fiboTime() throws Exception {
        long start = System.nanoTime();
        Fibonacci fibonacci = new Fibonacci();
        long fibo = fibonacci.compute(42);
        long end = System.nanoTime();
        // an estimate time in ns
        total += (end - start);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("average time in ms : " + ((total / 50.0) / 1000000.0));
    }

}