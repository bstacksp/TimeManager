package com.app.TimeManager.services;

import com.app.TimeManager.entities.dto.UserDto;
import java.time.LocalTime;

public interface TimeService {

	LocalTime getTime();
	void startTime(UserDto user);
	void endTime(UserDto user);
}
