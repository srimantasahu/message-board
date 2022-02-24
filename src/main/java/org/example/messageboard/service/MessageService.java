package org.example.messageboard.service;

import org.example.messageboard.bean.MessageDetails;

import java.util.List;

public interface MessageService {

    void addMessage(MessageDetails messageDetails);

    List<MessageDetails> getAllMessages();

}
