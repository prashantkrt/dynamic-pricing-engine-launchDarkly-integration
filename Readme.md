# Dynamic Pricing Engine

A Spring Boot application that demonstrates **dynamic pricing using feature flags** powered by LaunchDarkly.
The service allows real-time enabling or disabling of business features without restarting the application.

---

## Overview

This project shows how feature flags can be used to safely roll out new functionality in production systems.

Using LaunchDarkly, different pricing behaviors can be controlled dynamically, such as:

* Switching between pricing algorithms
* Enabling discounts
* Applying new tax calculations
* Providing premium user benefits

All changes happen **in real time** through LaunchDarkly.

---

## Tech Stack

* Java 17+
* Spring Boot
* LaunchDarkly Server SDK
* Maven

---

## Features

* Feature flag driven pricing logic
* Multiple rollout strategies
* Environment-based configuration (dev/prod)
* Real-time feature updates without application restart

---

## Running the Application

### 1. Set LaunchDarkly SDK key

Add environment variable:

```
LD_SDK_KEY_DEV=your-sdk-key
```

### 2. Run the application

```
mvn spring-boot:run
```

---

##  Test Endpoint

```
GET http://localhost:8080/price?userId=101&amount=1000
```

Toggle feature flags in LaunchDarkly and observe pricing changes instantly.

---

##  Project Structure

```
controller → REST endpoints
service    → pricing logic
feature    → feature flag handling
config     → LaunchDarkly configuration
```

---

## Purpose

This project demonstrates how modern backend services use feature flags to:

* Release features safely
* Perform gradual rollouts
* Test new functionality with real users
* Avoid redeployments


