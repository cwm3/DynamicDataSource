package com.southgis.demo.service;

import com.southgis.demo.domain.s.Message;

import java.util.List;

/**
 * @Classname IMessageService
 * @Author chengweiming
 * @Date 2020/2/27 10:53
 */
public interface IMessageService  {

    public void save(Message message);

    public List<Message> findAll();
}
