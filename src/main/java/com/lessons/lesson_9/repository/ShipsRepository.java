package com.lessons.lesson_9.repository;

import com.lessons.lesson_9.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipsRepository extends JpaRepository<Ship, Integer> {
    Ship findByName(String login);
}
