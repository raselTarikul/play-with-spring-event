package com.linkedin.events.promotion;

import com.linkedin.events.customer.CustomerRegistrationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerPromotionEventListener {

    private final PromotionService promotionService;

    @EventListener(condition = "#customerRegistrationEvent.customer.newsletter")
    public void onCustomerRegistrationEvent(CustomerRegistrationEvent customerRegistrationEvent){
            promotionService.applyPromotion(customerRegistrationEvent.getCustomer());
    }
}
