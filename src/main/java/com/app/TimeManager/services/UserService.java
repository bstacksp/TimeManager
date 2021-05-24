package com.app.TimeManager.services;

import com.app.TimeManager.entities.User;
import com.app.TimeManager.entities.dto.UserDto;

import java.util.List;

public interface UserService {

	Boolean login(String login, String password);

	List<User> getAllUsers();

	UserDto getUser(String name);

	void addUser(UserDto user);

	void deleteUser(Long id);
}
