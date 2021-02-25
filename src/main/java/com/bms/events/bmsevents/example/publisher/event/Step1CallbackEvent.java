package com.bms.events.bmsevents.example.publisher.event;

import lombok.Getter;

@Getter
public class Step1CallbackEvent extends GenericSpringEvent<String> {

    public Step1CallbackEvent(String data) {
        super(data);
    }
}
