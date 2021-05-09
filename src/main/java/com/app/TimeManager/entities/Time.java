package com.app.TimeManager.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "time")
public class Time {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "date_start")
	private LocalTime date_start;
	@Column(name = "date_end")
	private LocalTime date_end;

}
