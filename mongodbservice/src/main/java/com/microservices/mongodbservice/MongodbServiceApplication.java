package com.microservices.mongodbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongodbServiceApplication.class, args);
    }

}
