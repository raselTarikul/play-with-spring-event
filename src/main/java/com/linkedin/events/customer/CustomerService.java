package com.linkedin.events.customer;

import com.linkedin.events.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerService
{

    private final CustomerRepository customerRepository;

    private final EmailService emailService;

    private final ApplicationEventPublisher applicationEventPublisher;

    public void register(Customer customer)
    {
        customerRepository.save(customer);
//        emailService.sendRegisterEmail(customer);
        applicationEventPublisher.publishEvent(new CustomerRegistrationEvent(customer));
    }

    public void remove(Customer customer)
    {
        customerRepository.delete(customer);
        applicationEventPublisher.publishEvent(new CustomerRemovedEvent(customer));
    }
}
