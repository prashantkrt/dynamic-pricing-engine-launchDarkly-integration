package com.mylearning.dynamicpricingservicelaunchdarkly.service.impl;

import org.springframework.stereotype.Service;

@Service
public class PricingStrategyV2 {
    /**
     * Calculates price.
     * Example: ₹1000. will apply 10% discount
     */
    public double calculate(double amount) {
        return amount * 0.9;
    }
}