package com.bms.events.bmsevents.example.publisher.event;

import lombok.Data;

@Data
public class GenericSpringEvent<T> {

    private final T data;
}
