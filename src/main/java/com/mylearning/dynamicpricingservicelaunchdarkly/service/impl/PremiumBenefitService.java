package com.mylearning.dynamicpricingservicelaunchdarkly.service.impl;

import org.springframework.stereotype.Service;

@Service
public class PremiumBenefitService {
    /**
     * Applies premium benefit.
     * Example: additional ₹100 discount.
     */
    public double applyPremiumBenefit(double price) {
        return price - 100; // extra discount for premium users
    }
}
