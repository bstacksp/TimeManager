package com.app.TimeManager.services.impl;

import com.app.TimeManager.entities.Time;
import com.app.TimeManager.entities.User;
import com.app.TimeManager.repositories.TimeRepository;
import com.app.TimeManager.repositories.UsersRepository;
import com.app.TimeManager.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalTime;

@Service
public class TimeServiceImpl implements TimeService {

	@Autowired
	private TimeRepository timeRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public void startTime(User user) {
		LocalTime firstTime = LocalTime.now();
		Time time = new Time();
		time.setUserId(usersRepository.getByLogin(user.getLogin()));
		time.setDate_start(firstTime);
		timeRepository.save(time);
	}

	@Override
	public LocalTime getTime() {
		return null;
	}

	@Override
	public void endTime(User user) {
		LocalTime endTime = LocalTime.now();
		Time time = timeRepository.findTopByUserId(user.getId());
		time.setDate_end(endTime);
		timeRepository.save(time);
	}
}
