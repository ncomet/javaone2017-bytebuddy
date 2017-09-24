package fibonacci;

import memoization.Memoization;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FibonacciTest {

    private long total = 0L;

    private Fibonacci fibonacci;

    @BeforeClass
    public void setUp() throws Exception {
        Memoization memoization = new Memoization();
        fibonacci = memoization.of(Fibonacci.class);
        //fibonacci = new Fibonacci();
    }

    @Test(invocationCount = 50)
    public void fiboTime() throws Exception {
        long start = System.nanoTime();
        long res = fibonacci.compute(42);
        long end = System.nanoTime();

        System.out.println("="+res);

        total += (end - start);
    }

    @Test
    public void invocationCounter() throws Exception {
        fibonacci.compute(42);
        System.out.println(fibonacci);
    }

    @AfterClass
    public void afterTest() {
        System.out.println("******\nAverage time in ms : " + ((total / 50.0) / 1000000.0) + "\n******");
    }
}
