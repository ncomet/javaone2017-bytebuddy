package org.ncomet.fibonaccispringaop.service;

import org.springframework.stereotype.Component;

@Component
public class FibonacciService {

    public long compute(int n) {
        return n <= 1 ? n
                : compute(n - 2) + compute(n - 1);
    }

}
