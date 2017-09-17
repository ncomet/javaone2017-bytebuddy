package fibonacci;

import java.text.NumberFormat;
import java.util.Locale;

public class Fibonacci {

    private long invocations = 0;

    public long compute(int n) {
        invocations++;
        return n <= 1 ? n
                : compute(n - 2) + compute(n - 1);
    }

    @Override
    public String toString() {
        return "Fibonacci{" +
                "invocations=" + NumberFormat.getNumberInstance(Locale.US).format(invocations) +
                '}';
    }
}
