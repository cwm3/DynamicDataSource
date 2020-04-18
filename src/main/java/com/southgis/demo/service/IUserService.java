package com.southgis.demo.service;

import com.southgis.demo.domain.p.User;


import java.util.List;

/**
 * @Classname IUserService
 * @Author chengweiming
 * @Date 2020/2/27 10:52
 */
public interface IUserService  {

    public void add(User user);

    public List<User> findAll();

}
