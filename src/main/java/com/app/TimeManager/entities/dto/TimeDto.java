package com.app.TimeManager.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class TimeDto {

	private LocalTime firstTime;
	private LocalTime secondTime;
	private Double result;
}
