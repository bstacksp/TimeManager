package com.app.TimeManager.services.impl;

import com.app.TimeManager.entities.Time;
import com.app.TimeManager.repositories.TimeRepository;
import com.app.TimeManager.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;

@Service
public class TimeServiceImpl implements TimeService {

	@Autowired
	TimeRepository timeRepository;

	private Time time;
	private LocalTime localTime;
	private LocalTime firstTime;
	private LocalTime newTime;

	@Override
	public void startTime() {
		localTime = LocalTime.now();
		time = new Time();
		time.setDate_start(localTime);
		System.out.println("time = " + time);
	}

	@Override
	public LocalTime getTime() {
		if (time == null)
			return null;
		firstTime = time.getDate_start();
		localTime = LocalTime.now();
		int seconds = (firstTime.getSecond() + firstTime.getMinute() * 60 + firstTime.getHour() * 60 * 60) -
				(localTime.getSecond() + localTime.getMinute() * 60 + localTime.getHour() * 60 * 60);
		if (time.getDate_end() == null)
			newTime = LocalTime.of(
					seconds / 3600,
					seconds / 60 % 60,
					seconds % 60);
		System.out.println("time = " + newTime);
		return newTime;
	}
	@Override
	public void endTime() {
		localTime = LocalTime.now();
		time.setDate_end(localTime);
		timeRepository.save(time);
		System.out.println("time = " + time);
	}
}
