package com.kodegravity.inclass_exr.rules;

import com.kodegravity.inclass_exr.rules.model.OrderPricingRequest;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.stereotype.Service;

@Service
public class OrderPricingService {

    private static final String ORDER_PRICING_SESSION = "orderPricingSession";

    private final KieContainer kieContainer;

    public OrderPricingService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public OrderPricingRequest evaluate(OrderPricingRequest request) {
        request.setDiscountPercentage(0);
        request.setShippingFee(0.0);
        request.getAppliedRules().clear();

        StatelessKieSession kieSession = kieContainer.newStatelessKieSession(ORDER_PRICING_SESSION);
        kieSession.execute(request);
        return request;
    }
}
