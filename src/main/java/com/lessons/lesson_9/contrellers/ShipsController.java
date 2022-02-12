package com.lessons.lesson_9.contrellers;

import com.lessons.lesson_9.dto.ShipDto;
import com.lessons.lesson_9.exception.ValidationException;
import com.lessons.lesson_9.service.ShipsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ships")
@RestController
@AllArgsConstructor
public class ShipsController {

    private final ShipsService shipsService;

    @PostMapping("/save")
    public ShipDto saveShips(@RequestBody ShipDto shipDto) throws ValidationException {
        return shipsService.saveShip(shipDto);
    }

    @GetMapping("/findAll")
    public List<ShipDto> findAllShips() {
        return shipsService.findAll();
    }

    @GetMapping("/findByName")
    public ShipDto findByName(@RequestParam String name) {
        return shipsService.findByName(name);
    }

    @GetMapping("/delete/{id}")
    public String deleteShips(@PathVariable Integer id) {
        shipsService.deleteShip(id);
        return "redirect:/ships/findAll";
    }
}
