package com.bms.events.bmsevents.example.endpoint;

import com.bms.events.bmsevents.example.publisher.StepEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/callback")
@RequiredArgsConstructor
public class StepCallbackController {

    private final StepEventPublisher stepEventPublisher;

    @PostMapping(value = "/step1/{status}")
    public void callbackStep1(@PathVariable String status) {
        log.info("step-1 callback has been called with status {}", status);
        stepEventPublisher.publishStep1EventWithStatus(status);
    }

    @PostMapping(value = "/step2/{message}")
    public void callbackStep2(@PathVariable String message) {
        log.info("step-2 callback has been called with message {}", message);
        stepEventPublisher.publishStep2EventWithMessage(message);
    }
}
