package com.osanda.cloudgateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/studentFallBack")
    public Mono<String> orderServiceFallBack() {
        return Mono.just("Student Service is taking too long to respond or is down. Please try again later");
    }
    
    @RequestMapping("/classFallback")
    public Mono<String> paymentServiceFallBack() {
        return Mono.just("Class Service is taking too long to respond or is down. Please try again later");
    }
    
    @RequestMapping("/enrollmentFallback")
    public Mono<String> enrollmentFallBack() {
        return Mono.just("Enrollment Service is taking too long to respond or is down. Please try again later");
    }
}
