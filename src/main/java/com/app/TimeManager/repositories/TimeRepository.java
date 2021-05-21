package com.app.TimeManager.repositories;

import com.app.TimeManager.entities.Time;
import com.app.TimeManager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
	Time findTopByUserId(Long id);

}
