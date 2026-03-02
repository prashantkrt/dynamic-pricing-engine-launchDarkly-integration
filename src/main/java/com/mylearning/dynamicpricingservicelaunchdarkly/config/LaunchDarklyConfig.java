package com.mylearning.dynamicpricingservicelaunchdarkly.config;

import com.launchdarkly.sdk.server.LDClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaunchDarklyConfig {

    @Value("${launchdarkly.sdk-key}")
    private String sdkKey;

    @Bean(destroyMethod = "close")
    public LDClient ldClient() {
        if (sdkKey == null || sdkKey.isBlank()) {
            throw new IllegalStateException(
                    "LD_SDK_KEY environment variable not set");
        }
        return new LDClient(sdkKey);
    }
}
