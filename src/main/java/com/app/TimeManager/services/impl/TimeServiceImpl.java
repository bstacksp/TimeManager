package com.app.TimeManager.services.impl;

import com.app.TimeManager.entities.Time;
import com.app.TimeManager.entities.dto.TimeDto;
import com.app.TimeManager.entities.dto.UserDto;
import com.app.TimeManager.repositories.TimeRepository;
import com.app.TimeManager.repositories.UsersRepository;
import com.app.TimeManager.services.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.ZonedDateTime;

@Service
public class TimeServiceImpl implements TimeService {

	private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private TimeRepository timeRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public void startTime(UserDto user) {
		ZonedDateTime firstTime = ZonedDateTime.now();
		Time time = new Time();
		log.info("Time start for user [{}]", user);
		time.setUserId(usersRepository.getByLogin(user.getLogin()));
		time.setDate_start(firstTime);
		timeRepository.save(time);
	}

	@Override
	public LocalTime getTime(UserDto user) {

		LocalTime nowTime = LocalTime.now();
		TimeDto time = new TimeDto(timeRepository.findFirstByUserIdOrderByIdDesc(usersRepository.getByLogin(user.getLogin())));
		//TODO : Допилить отображение времени за один день
//		if (time.getDate_end() != null) {
			int seconds = (nowTime.getSecond() + nowTime.getMinute() * 60 + nowTime.getHour() * 60 * 60) -
					(time.getDate_start().getSecond() + time.getDate_start().getMinute() * 60 + time.getDate_start().getHour() * 60 * 60);
			if (time.getDate_end() == null)
				nowTime = LocalTime.of(
						seconds / 3600,
						seconds / 60 % 60,
						seconds % 60);
//		} else {
//			int seconds = (time.getDate_end().getSecond() + time.getDate_end().getMinute() * 60 + time.getDate_end().getHour() * 60 * 60) -
//					(time.getDate_start().getSecond() + time.getDate_start().getMinute() * 60 + time.getDate_start().getHour() * 60 * 60);
//			if (time.getDate_end() == null)
//				nowTime = LocalTime.of(
//						seconds / 3600,
//						seconds / 60 % 60,
//						seconds % 60);
//		}
		return nowTime;
	}

	@Override
	public void endTime(UserDto user) {
		ZonedDateTime endTime = ZonedDateTime.now();
		Time time = timeRepository.findFirstByUserIdOrderByIdDesc(usersRepository.getByLogin(user.getLogin()));
		time.setDate_end(endTime);
		log.info("Session end for user {} - {}", user.getLogin(), time);
		timeRepository.save(time);
		resultTime(time);
	}

	@Override
	public void resultTime(Time time) {

		int seconds = (time.getDate_end().getSecond() + time.getDate_end().getMinute() * 60 + time.getDate_end().getHour() * 60 * 60) -
				(time.getDate_start().getSecond() + time.getDate_start().getMinute() * 60 + time.getDate_start().getHour() * 60 * 60);
		time.setResult(LocalTime.of(
				seconds / 3600,
				seconds / 60 % 60,
				seconds % 60));
		timeRepository.save(time);
	}
}
