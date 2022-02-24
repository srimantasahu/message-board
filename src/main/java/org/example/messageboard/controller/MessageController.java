package org.example.messageboard.controller;

import org.example.messageboard.bean.MessageDetails;
import org.example.messageboard.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> addMessage(@RequestBody MessageDetails messageDetails) {
        try {
            messageService.addMessage(messageDetails);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("New message added successfully!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("message failed to add!");
        }
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAllMessages() {
        try {
            List<MessageDetails> messages = messageService.getAllMessages();
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(messages);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("message failed to add!");
        }
    }

}
