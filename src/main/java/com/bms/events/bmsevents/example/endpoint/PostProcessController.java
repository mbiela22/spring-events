package com.bms.events.bmsevents.example.endpoint;

import com.bms.events.bmsevents.example.postprocess.PostProcess;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/post-process")
@RequiredArgsConstructor
public class PostProcessController {

    private final PostProcess postProcess;

    @PostMapping(value = "/init")
    public void initPostProcess() {
        log.info("post-process has been initialized");
        postProcess.start();
    }
}
