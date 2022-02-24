package org.example.messageboard.repository.impl;

import org.example.messageboard.bean.MessageDetails;
import org.example.messageboard.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private static final Logger logger = LoggerFactory.getLogger(MessageRepositoryImpl.class);

    private static final List<MessageDetails> messages = new ArrayList<>();

    private static final AtomicInteger msgIdSequence = new AtomicInteger(1);

    @Override
    public Integer addMessage(MessageDetails messageDetails) {
        Integer generatedId = msgIdSequence.getAndIncrement();
        messageDetails.setId(generatedId);
        messages.add(messageDetails);
        return generatedId;
    }

    @Override
    public List<MessageDetails> getAllMessages() {
        return messages;
    }

}
