package org.example.messageboard.repository;

import org.example.messageboard.bean.MessageDetails;

import java.util.List;

public interface MessageRepository {

    Integer addMessage(MessageDetails messageDetails);

    List<MessageDetails> getAllMessages();

}
