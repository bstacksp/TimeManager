package com.app.TimeManager.repositories;

import com.app.TimeManager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
	User getUserByLoginAndPassword(String login, String password);
	User getByLogin(String Login);
}
