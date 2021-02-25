package com.bms.events.bmsevents.example.postprocess;

import com.bms.events.bmsevents.example.postprocess.step.FirstStep;
import com.bms.events.bmsevents.example.postprocess.step.SecondStep;
import com.bms.events.bmsevents.example.publisher.event.Step1CallbackEvent;
import com.bms.events.bmsevents.example.publisher.event.Step2CallbackEvent;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PostProcess {

    private final FirstStep firstStep;
    private final SecondStep secondStep;

    //for tests
    @Setter
    @Getter
    private boolean completedFirstStep;
    @Setter
    @Getter
    private boolean completedSecondStep;

    public void start() {
        firstStep.execute();
    }

    @EventListener
    public void completeFirstStep(@NonNull Step1CallbackEvent event) {
        setCompletedFirstStep(true);
        log.info("step-1 has been competed with status {}", event.getData());
        log.info("step-2 has been started...");
        secondStep.execute();
    }

    @EventListener
    public void completeSecondStep(@NonNull Step2CallbackEvent event) {
        setCompletedSecondStep(true);
        log.info("step-2 has been competed {}", event.getData());
    }
}
