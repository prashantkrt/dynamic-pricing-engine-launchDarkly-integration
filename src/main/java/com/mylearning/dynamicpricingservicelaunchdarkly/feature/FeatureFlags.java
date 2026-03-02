package com.mylearning.dynamicpricingservicelaunchdarkly.feature;

public final class FeatureFlags {
    private FeatureFlags() {}
    public static final String PRICING_V2 = "pricing-v2-rollout";
    public static final String DYNAMIC_DISCOUNT = "dynamic-discount-enabled";
    public static final String TAX_V2 = "tax-calculation-v2";
    public static final String PREMIUM_BENEFITS = "premium-user-benefits";
}
