package com.bms.events.bmsevents.example;

import com.bms.events.bmsevents.example.postprocess.PostProcess;
import com.bms.events.bmsevents.example.publisher.StepEventPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BmsEventsApplicationTests {

    @Autowired
    private PostProcess postProcess;

    @Autowired
    private StepEventPublisher stepEventPublisher;

    @Test
    void testPublishFirstStepEvent() {
        assertFalse(postProcess.isCompletedFirstStep());
        stepEventPublisher.publishStep1EventWithStatus("ok");
        assertTrue(postProcess.isCompletedFirstStep());
    }

    @Test
    void testPublishSecondStepEvent() {
        assertFalse(postProcess.isCompletedSecondStep());
        stepEventPublisher.publishStep2EventWithMessage("hello");
        assertTrue(postProcess.isCompletedSecondStep());
    }

}
