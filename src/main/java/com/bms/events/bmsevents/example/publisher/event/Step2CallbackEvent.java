package com.bms.events.bmsevents.example.publisher.event;

import lombok.Getter;

@Getter
public class Step2CallbackEvent extends GenericSpringEvent<String> {

    public Step2CallbackEvent(String message) {
        super(message);
    }
}
