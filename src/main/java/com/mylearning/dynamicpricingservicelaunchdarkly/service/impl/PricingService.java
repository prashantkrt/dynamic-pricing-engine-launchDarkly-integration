package com.mylearning.dynamicpricingservicelaunchdarkly.service.impl;

import com.mylearning.dynamicpricingservicelaunchdarkly.feature.FeatureFlags;
import com.mylearning.dynamicpricingservicelaunchdarkly.service.FeatureFlagService;
import org.springframework.stereotype.Service;

@Service
public class PricingService {
    private final FeatureFlagService flagService;
    private final PricingStrategyV1 v1;
    private final PricingStrategyV2 v2;
    private final DiscountService discountService;
    private final TaxService taxService;
    private final PremiumBenefitService premiumService;

    public PricingService(
            FeatureFlagService flagService,
            PricingStrategyV1 v1,
            PricingStrategyV2 v2,
            DiscountService discountService,
            TaxService taxService,
            PremiumBenefitService premiumService) {

        this.flagService = flagService;
        this.v1 = v1;
        this.v2 = v2;
        this.discountService = discountService;
        this.taxService = taxService;
        this.premiumService = premiumService;
    }


    public double calculatePrice(String userId, double amount) {
        boolean newPricingEnabled =
                flagService.isEnabled("pricing-v2-rollout", userId);

        // OLD LOGIC
        if (!newPricingEnabled) {
            return amount;
        }

        // NEW LOGIC (10% discount)
        return amount * 0.9;
    }


    public double calculate(String userId, double amount) {
        System.out.println(
                flagService.isEnabled(
                        FeatureFlags.PRICING_V2, "101"));

        // Pricing version
        double price = flagService.isEnabled(
                FeatureFlags.PRICING_V2, userId)
                ? v2.calculate(amount) // new version
                : v1.calculate(amount); // old version

        // Discount rollout
        if (flagService.isEnabled(FeatureFlags.DYNAMIC_DISCOUNT, userId)) {
            price = discountService.applyDiscount(price);
        }

        // Tax rollout
        if (flagService.isEnabled(FeatureFlags.TAX_V2, userId)) {
            price = taxService.applyTax(price);
        }

        // Premium benefits rollout
        if (flagService.isEnabled(FeatureFlags.PREMIUM_BENEFITS, userId)) {
            price = premiumService.applyPremiumBenefit(price);
        }

        return price;
    }


}
