package org.demon.server.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("web application start ...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("web application destroy ...");
    }
}
