package com.linkedin.events.email;

import com.linkedin.events.customer.CustomerRegistrationEvent;
import com.linkedin.events.customer.CustomerRemovedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailListeners {

    public final EmailService emailService;

    @EventListener
    public void onRegistrationEvent(CustomerRegistrationEvent customerRegistrationEvent){
        emailService.sendRegisterEmail(customerRegistrationEvent.getCustomer());

    }

    @EventListener
    public  void onCustomerRemoveEvent(CustomerRemovedEvent customerRemovedEvent){
        emailService.sendCustomerRemovedEmail(customerRemovedEvent.getCustomer());
    }
}
