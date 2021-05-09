package com.app.TimeManager.services;

import com.app.TimeManager.entities.Time;

import java.time.LocalTime;

public interface TimeService {

	LocalTime getTime();
	void startTime();
	void endTime();
}
