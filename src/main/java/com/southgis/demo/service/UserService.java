package com.southgis.demo.service;

import com.southgis.demo.annotation.TargetDataSource;
import com.southgis.demo.domain.p.User;
import com.southgis.demo.domain.p.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@TargetDataSource(name = "dataSource")
	public void add(User user) {
		userRepository.save(user);
	}

	@Override
	@TargetDataSource(name = "dataSource")
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
