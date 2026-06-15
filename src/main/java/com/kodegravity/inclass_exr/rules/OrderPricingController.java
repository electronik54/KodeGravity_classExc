package com.kodegravity.inclass_exr.rules;

import com.kodegravity.inclass_exr.rules.model.OrderPricingRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class OrderPricingController {

    private final OrderPricingService orderPricingService;

    public OrderPricingController(OrderPricingService orderPricingService) {
        this.orderPricingService = orderPricingService;
    }

    /*
    $body = @{
      customerTier = "GOLD"
      totalAmount  = 120.0
      loyaltyYears = 3
    }
     */
    @PostMapping("/evaluate")
    public OrderPricingRequest evaluate(@RequestBody OrderPricingRequest request) {
        return orderPricingService.evaluate(request);
    }
}
