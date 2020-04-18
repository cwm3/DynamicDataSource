package com.southgis.demo.service;

import com.southgis.demo.annotation.TargetDataSource;
import com.southgis.demo.domain.s.Message;
import com.southgis.demo.domain.s.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Classname MessageService
 * @Author chengweiming
 * @Date 2020/2/27 10:52
 */
@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    @TargetDataSource(name = "data2")
    public void save(Message message) {
        message.setId(UUID.randomUUID().toString());
        messageRepository.save(message);
    }
    @Override
    @TargetDataSource(name = "data2")
    public List<Message> findAll() {
        return messageRepository.findAll();
    }
}
