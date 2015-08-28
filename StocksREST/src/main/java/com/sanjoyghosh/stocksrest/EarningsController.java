package com.sanjoyghosh.stocksrest;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EarningsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/earnings")
    public Earnings greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Earnings(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
