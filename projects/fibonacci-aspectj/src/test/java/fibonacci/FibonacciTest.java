package fibonacci;

import org.testng.annotations.AfterClass;
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

    @AfterClass
    public void afterTest() {
        System.out.println("******\nAverage time in ms : " + ((total / 50.0) / 1000000.0) + "\n******");
    }

}