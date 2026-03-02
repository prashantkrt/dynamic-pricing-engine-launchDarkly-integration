package com.mylearning.dynamicpricingservicelaunchdarkly.service.impl;

import org.springframework.stereotype.Service;

@Service
public class TaxService {
    /**
     * Applies tax.
     * Example: ₹1000. will apply 18% tax.
     */
    public double applyTax(double amount) {
        return amount + (amount * 0.18);
    }
}