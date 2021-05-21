package com.app.TimeManager.entities.dto;

import com.app.TimeManager.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {

	private Long id;
	private String login;
	private String password;

	public UserDto (User user) {
		this.id = user.getId();
		this.login = user.getLogin();
		this.password = user.getPassword();
	}
}
