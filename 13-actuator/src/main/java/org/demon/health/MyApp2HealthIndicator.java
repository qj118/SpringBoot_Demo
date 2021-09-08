package org.demon.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyApp2HealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

        Map<String, Object> map = new HashMap<>();
        if(1 == 1){
            // builder.up();
            builder.status(Status.UP);
            map.put("ms", 100);
        }else{
            // builder.down();
            builder.status(Status.OUT_OF_SERVICE);
            map.put("ms", 3000);
            map.put("err", "连接超时");
        }

        builder.withDetail("code", 100)
                .withDetails(map);
    }
}
