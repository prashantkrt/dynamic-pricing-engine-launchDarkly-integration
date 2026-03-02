package com.mylearning.dynamicpricingservicelaunchdarkly.service;

import com.launchdarkly.sdk.EvaluationDetail;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.server.LDClient;
import org.springframework.stereotype.Service;

@Service
public class FeatureFlagService {

    private final LDClient ldClient;

    public FeatureFlagService(LDClient ldClient) {
        this.ldClient = ldClient;
    }


 /*
     LDContext context = LDContext.builder("101")
        .kind("user")
        .set("plan", "premium")
        .set("country", "IN")
        .build();

     or
     private LDContext buildContext(String userId) {
      return LDContext.builder(userId)
            .kind("user")
            .set("country", "IN")
            .set("app", "pricing-engine")
            .build();
      }
   */
//    private LDContext buildContext(String userId) {
//        return LDContext.builder(userId)
//                .kind("user") // type of entity
//                .build();
//    }

//    public boolean isEnabled(String flagKey, String userId) {
//        return ldClient.boolVariation(flagKey, buildContext(userId), false);
//    }

    public boolean isEnabled(String flagKey, String userId) {

        LDContext context = LDContext.builder(userId)
                .kind("user")
                .build();

        EvaluationDetail<Boolean> detail =
                ldClient.boolVariationDetail(flagKey, context, false);

        System.out.println(
                "FLAG=" + flagKey +
                        " VALUE=" + detail.getValue() +
                        " REASON=" + detail.getReason()
        );
        //FLAG=pricing-v2-rollout VALUE=false REASON=OFF
        //FLAG=dynamic-discount-enabled VALUE=false REASON=OFF
        //FLAG=tax-calculation-v2 VALUE=false REASON=OFF
        //FLAG=premium-user-benefits VALUE=false REASON=OFF

        return detail.getValue();
    }
}