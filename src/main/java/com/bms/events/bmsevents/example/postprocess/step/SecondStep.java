package com.bms.events.bmsevents.example.postprocess.step;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SecondStep implements StepI {
    @Override
    public void execute() {
        log.info("Start step-2 processing");
    }
}
