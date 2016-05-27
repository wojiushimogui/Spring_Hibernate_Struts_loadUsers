package com.register.dao;

import java.util.List;

import com.register.model.User;

public interface UserDao {
	public void save(User user);
	public boolean exists(User user);
	public List<User> getUsers();
}
