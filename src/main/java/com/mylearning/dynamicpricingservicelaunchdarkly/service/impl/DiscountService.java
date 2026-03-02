package com.mylearning.dynamicpricingservicelaunchdarkly.service.impl;

import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    /**
     * Applies discount.
     * Example: ₹50 discount.
     */
    public double applyDiscount(double amount) {
        return amount - 50;
    }
}