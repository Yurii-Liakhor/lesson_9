package com.lessons.lesson_9.service;

import com.lessons.lesson_9.dto.ShipDto;
import com.lessons.lesson_9.entity.Ship;
import org.springframework.stereotype.Component;

@Component
public class ShipsConverter {

    public Ship fromShipDtoToShip(ShipDto shipDto) {
        Ship ship = new Ship();
        ship.setId(shipDto.getId());
        ship.setName(shipDto.getName());
        ship.setSpeed1(shipDto.getSpeed1());
        ship.setSpeed2(shipDto.getSpeed2());
        ship.setSpeed3(shipDto.getSpeed3());
        return ship;
    }

    public ShipDto fromShipToShipDto(Ship ship) {
        return ShipDto.builder()
                .id(ship.getId())
                .name(ship.getName())
                .speed1(ship.getSpeed1())
                .speed2(ship.getSpeed2())
                .speed3(ship.getSpeed3())
                .build();
    }
}
