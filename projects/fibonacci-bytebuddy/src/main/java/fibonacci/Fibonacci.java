package fibonacci;

public class Fibonacci {

    public long compute(int n) {
        return n <= 1 ? n
                : compute(n - 2) + compute(n - 1);
    }

}
