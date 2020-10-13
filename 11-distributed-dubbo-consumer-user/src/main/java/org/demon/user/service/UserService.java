package org.demon.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.demon.ticket.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Reference
    TicketService ticketService;

    public void buy(){
        String ticket = ticketService.getTicket();
        System.out.println("买到票了: " + ticket);
    }
}
