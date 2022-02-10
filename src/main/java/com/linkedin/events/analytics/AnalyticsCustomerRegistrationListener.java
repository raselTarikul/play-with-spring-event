package com.linkedin.events.analytics;

import com.linkedin.events.customer.CustomerRegistrationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnalyticsCustomerRegistrationListener {

    private final AnalyticsService analyticsService;

    @EventListener
    @Async
    public void onCustomerRegistrationEvent(CustomerRegistrationEvent customerRegistrationEvent){
        analyticsService.registerNewCustomer(customerRegistrationEvent.getCustomer());
    }
}
