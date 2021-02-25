package com.bms.events.bmsevents.example.publisher;

import com.bms.events.bmsevents.example.publisher.event.Step1CallbackEvent;
import com.bms.events.bmsevents.example.publisher.event.Step2CallbackEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StepEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishStep1EventWithStatus(String status) {
        log.info("step-1 callback has been called with status {}", status);
        Step1CallbackEvent step1CallbackEvent = new Step1CallbackEvent(status);
        applicationEventPublisher.publishEvent(step1CallbackEvent);
    }

    public void publishStep2EventWithMessage(String message) {
        log.info("step-2 callback has been called with message {}", message);
        Step2CallbackEvent step2CallbackEvent = new Step2CallbackEvent(message);
        applicationEventPublisher.publishEvent(step2CallbackEvent);
    }
}
