package com.cloud.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    private static final Logger LOGGER = LogManager.getLogger(DemoApplication.class.getName());
    public static void main(String[] args) {
        LOGGER.debug("Demo Application - starting");
        SpringApplication.run(DemoApplication.class, args);
    }
}