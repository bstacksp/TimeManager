package com.app.TimeManager.services;

import com.app.TimeManager.entities.Time;
import com.app.TimeManager.entities.User;

import java.time.LocalTime;

public interface TimeService {

	LocalTime getTime();
	void startTime(User user);
	void endTime(User user);
}
