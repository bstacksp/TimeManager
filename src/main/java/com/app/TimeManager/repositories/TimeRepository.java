package com.app.TimeManager.repositories;

import com.app.TimeManager.entities.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {

}
