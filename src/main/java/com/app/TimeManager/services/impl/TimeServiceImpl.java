package com.app.TimeManager.services.impl;

import com.app.TimeManager.entities.Time;
import com.app.TimeManager.entities.dto.UserDto;
import com.app.TimeManager.repositories.TimeRepository;
import com.app.TimeManager.repositories.UsersRepository;
import com.app.TimeManager.services.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class TimeServiceImpl implements TimeService {

	private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private TimeRepository timeRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public void startTime(UserDto user) {
		LocalTime firstTime = LocalTime.now();
		Time time = new Time();
		log.info("Time start for user [{}]", user);
		time.setUserId(usersRepository.getByLogin(user.getLogin()));
		time.setDate_start(firstTime);
		timeRepository.save(time);
	}

	@Override
	public LocalTime getTime() {
		return null;
	}

	@Override
	public void endTime(UserDto user) {
		LocalTime endTime = LocalTime.now();
		Time time = timeRepository.findTopOrderByUserId(usersRepository.getByLogin(user.getLogin()));
		log.info("Session end for user {} - {}", user.getId(), time);
		time.setDate_end(endTime);
		timeRepository.save(time);
	}
}
