package com.vladimiro.shift.consumer.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@ConditionalOnProperty(havingValue = "true", prefix = "scheduling", name = "enabled")
@EnableScheduling
@Configuration
public class SchedulingConfig {

}
