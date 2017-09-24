package fibonacci;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FibonacciTest {

    private long total = 0L;

    private Fibonacci fibonacci;

    @BeforeClass
    public void setUp() throws Exception {
        fibonacci = new Fibonacci();
    }

    @Test(invocationCount = 50)
    public void fiboTime() throws Exception {
        long start = System.nanoTime();
        long result = fibonacci.compute(42);
        long end = System.nanoTime();

        System.out.println("fibo(42)="+result);

        total += (end - start);
    }

    @AfterClass
    public void afterTest() {
        System.out.println("******\nAverage time in ms : " + ((total / 50.0) / 1000000.0) + "\n******");
    }

}