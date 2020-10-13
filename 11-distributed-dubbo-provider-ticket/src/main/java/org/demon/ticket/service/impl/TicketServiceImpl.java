package org.demon.ticket.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import org.demon.ticket.service.TicketService;
import org.springframework.stereotype.Component;

@Component
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《夺冠》";
    }
}
