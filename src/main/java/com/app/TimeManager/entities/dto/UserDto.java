package com.app.TimeManager.entities.dto;

import com.app.TimeManager.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private Long id;
	private String login;
	private String password;

	public UserDto (User user) {
		this.id = user.getId();
		this.login = user.getLogin();
		this.password = user.getPassword();
	}

	public UserDto (String login, String password) {
		this.login = login;
		this.password = password;
	}

}
