package com.mylearning.dynamicpricingservicelaunchdarkly.controller;

import com.mylearning.dynamicpricingservicelaunchdarkly.service.impl.PricingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricingController {

    private final PricingService pricingService;

    public PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    /**
     * Test endpoint to evaluate feature flags.
     * Example:
     * http://localhost:8080/price?userId=101&amount=1000
     */
    @GetMapping("/price")
    public double getPrice(@RequestParam String userId, @RequestParam double amount) {
        return pricingService.calculatePrice(userId, amount);
    }


    /**
    * http://localhost:8080/price?userId=101&amount=1000
    * */
    @GetMapping("/calculatePrice")
    public double getDetailedPrice(@RequestParam String userId, @RequestParam double amount) {
        return pricingService.calculate(userId, amount);
    }
}
