package com.linkedin.events.customer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CustomerRemovedEvent {

    private final Customer customer;
}
