package org.demon.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    // 表示每个周一到周六的每分钟的0-4秒每秒执行一次
    @Scheduled(cron="0-4 * * * * MON-SAT")
    public void say(){
        System.out.println("I'm here!");
    }
}
