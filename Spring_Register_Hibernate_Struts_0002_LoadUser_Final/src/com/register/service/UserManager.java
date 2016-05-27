package com.register.service;

import java.util.List;

import com.register.model.User;

public interface UserManager {
	public void save(User user);
	public boolean exists(User user);
	public List<User> getUsers();
	
}
