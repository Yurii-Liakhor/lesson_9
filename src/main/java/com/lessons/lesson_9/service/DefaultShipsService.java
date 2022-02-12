package com.lessons.lesson_9.service;

import com.lessons.lesson_9.dto.ShipDto;
import com.lessons.lesson_9.entity.Ship;
import com.lessons.lesson_9.exception.ValidationException;
import com.lessons.lesson_9.repository.ShipsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultShipsService implements ShipsService {

    private final ShipsRepository shipsRepository;
    private final ShipsConverter shipsConverter;


    @Override
    public ShipDto saveShip(ShipDto shipDto) throws ValidationException {
        validateShipDto(shipDto);
        Ship savedShips = shipsRepository.save(shipsConverter.fromShipDtoToShip(shipDto));
        return shipsConverter.fromShipToShipDto(savedShips);
    }

    private void validateShipDto(ShipDto shipDto) throws ValidationException {
        if (isNull(shipDto)) {
            throw new ValidationException("Object ship is null");
        }
        if (isNull(shipDto.getName())) {
            throw new ValidationException("Name is empty");
        }
    }

    @Override
    public void deleteShip(Integer shipId) {
        shipsRepository.deleteById(shipId);
    }

    @Override
    public ShipDto findByName(String name) {
        Ship ship = shipsRepository.findByName(name);
        if (ship != null) {
            return shipsConverter.fromShipToShipDto(ship);
        }
        return null;
    }

    @Override
    public List<ShipDto> findAll() {
        return shipsRepository.findAll()
                .stream()
                .map(shipsConverter::fromShipToShipDto)
                .collect(Collectors.toList());
    }
}
