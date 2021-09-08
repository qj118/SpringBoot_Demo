package org.demon.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "my-app")
public class MyAppEndpoint {

    /**
     * 读操作，即访问该节点时显示的信息
     * @return
     */
    @ReadOperation
    public Map getDockerInfo(){
        // 断点的读操作
        return Collections.singletonMap("info", "docker started ...");
    }

    /**
     * 写操作，如 docker 重启
     */
    @WriteOperation
    public void restartDocker(){
        System.out.println("docker restarted ...");
    }
}
