package org.demon.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyAppHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().build();
        //return Health.down().withDetail("msg", "未知异常").build();
    }
}
