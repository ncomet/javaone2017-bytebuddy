package org.ncomet.fibonaccispringaop.resource;

import org.ncomet.fibonaccispringaop.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fibonacci/{n}")
public class FibonacciResource {

    private final FibonacciService fibonacciService;

    @Autowired
    public FibonacciResource(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @GetMapping
    public ResponseEntity<String> fibo(@PathVariable int n) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        long result = fibonacciService.compute(n);
        stopWatch.stop();
        StopWatch stopWatch2 = new StopWatch();
        stopWatch2.start();
        fibonacciService.compute(n);
        stopWatch2.stop();
        return ResponseEntity.ok("fibonacci(" + n + ") = " + result + "<br/> The first time, it took " + stopWatch.getLastTaskTimeMillis() + "ms <br/>The second time, " + stopWatch2.getLastTaskTimeMillis() + "ms");
    }
}
