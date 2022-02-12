package com.lessons.lesson_9.service;

import com.lessons.lesson_9.dto.ShipDto;
import com.lessons.lesson_9.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShipsService {

    ShipDto saveShip(ShipDto shipDto) throws ValidationException;

    void deleteShip(Integer shipId);

    ShipDto findByName(String name);

    List<ShipDto> findAll();
}
