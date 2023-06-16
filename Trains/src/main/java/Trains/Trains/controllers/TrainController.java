package Trains.Trains.controllers;

import Trains.Trains.models.Train;
import Trains.Trains.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Класс для обработки пользовательских запросов
 * */
@RestController
@RequestMapping("/train")
public class TrainController {
    @Autowired
    private TrainService trainService;
    /**
     * Метод для вывода инфрмации обо всех поездах
     * @return Возвращает список всех поездов
     * */
    @GetMapping
    public ResponseEntity<?> allTrains() {
        List<Train> trains = trainService.getAll();
        if (trains.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok().body(trains);
    }
    /**
     * Метод для сохранения в бд введенной пользователем информации о поезде
     * @return При успешком сохранении возвращает сообщение "Поезд добавлен"
     * */
    @PostMapping("/create")
    public ResponseEntity<?> createTrain(@RequestBody Train train) {
        trainService.create(train);
        return ResponseEntity.ok().body("Поезд добавлен");
    }
}
