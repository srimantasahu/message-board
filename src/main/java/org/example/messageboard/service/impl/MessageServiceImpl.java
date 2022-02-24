package org.example.messageboard.service.impl;

import org.example.messageboard.bean.MessageDetails;
import org.example.messageboard.repository.MessageRepository;
import org.example.messageboard.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void addMessage(MessageDetails messageDetails) {
        logger.info("Adding new message with \n email : {} \n message : {}", messageDetails.getEmail(), messageDetails.getMessage());
        Integer generatedId = messageRepository.addMessage(messageDetails);
        logger.info("Added message with for email : {} with id : {}", messageDetails.getEmail(), generatedId);
    }

    @Override
    public List<MessageDetails> getAllMessages() {
        List<MessageDetails> messages = messageRepository.getAllMessages();
        logger.debug("Returning all message with count : {}", messages.size());
        return messages;
    }

}
