package com.mylearning.dynamicpricingservicelaunchdarkly.service.impl;

import org.springframework.stereotype.Service;

@Service
public class PricingStrategyV1 {
    /**
     * Calculates price.
     * Example: ₹1000.
     */
    public double calculate(double amount) {
        return amount;
    }
}