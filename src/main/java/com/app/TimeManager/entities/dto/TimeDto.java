package com.app.TimeManager.entities.dto;

import com.app.TimeManager.entities.Time;
import lombok.Getter;

import java.time.LocalTime;
import java.time.ZonedDateTime;

@Getter
public class TimeDto {

	private ZonedDateTime date_start;

	private ZonedDateTime date_end;

	private LocalTime result;

	public TimeDto(Time time) {
		this.date_start = time.getDate_start();
		this.date_end = time.getDate_end();
		this.result = time.getResult();
	}
}
