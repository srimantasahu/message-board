package org.example.messageboard.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example.messageboard")
public class MessageBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageBoardApplication.class, args);
    }

}