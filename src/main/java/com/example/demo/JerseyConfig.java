package com.example.demo;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.example.demo.controller.ExpenseReportController;

@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerServices();
    }

    private void registerServices() {
    		register(ExpenseReportController.class);
    }
}