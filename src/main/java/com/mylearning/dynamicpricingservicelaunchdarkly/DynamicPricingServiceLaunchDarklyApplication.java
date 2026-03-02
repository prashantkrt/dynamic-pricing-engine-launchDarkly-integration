package com.mylearning.dynamicpricingservicelaunchdarkly;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class DynamicPricingServiceLaunchDarklyApplication {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(DynamicPricingServiceLaunchDarklyApplication.class, args);
    }

    @PostConstruct
    public void checkProfile() {
        System.out.println("Active profiles: " + Arrays.toString(env.getActiveProfiles()));
        System.out.println(env.getProperty("launchdarkly.sdk-key") != null);
    }
    @PostConstruct
    public void debugEnv() {
        System.out.println(
                "ENV LD_SDK_KEY_DEV = "
                        + System.getenv("LD_SDK_KEY_DEV")
        );
        System.out.println("Profiles: " + Arrays.toString(env.getActiveProfiles()));

        System.out.println("SDK from ENV: " + System.getenv("LD_SDK_KEY_DEV"));

        System.out.println("SDK from Spring: " + env.getProperty("launchdarkly.sdk-key"));
    }

}
