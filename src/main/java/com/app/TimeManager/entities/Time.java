package com.app.TimeManager.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "time")
public class Time {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;

	@Column(name = "date_start")
	private ZonedDateTime date_start;

	@Column(name = "date_end")
	private ZonedDateTime date_end;

	@Column(name = "result")
	private LocalTime result;

}
