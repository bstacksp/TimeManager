package com.app.TimeManager.services;

import com.app.TimeManager.entities.User;

import java.util.List;

public interface UserService {

	Boolean login(String login, String password);

	List<User> getAllUsers();

	void addUser(User user);

	void deleteUser(Long id);
}
