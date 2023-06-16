package Trains.Trains.controllers;


import Trains.Trains.models.Schedule;
import Trains.Trains.services.TrainService;
import Trains.Trains.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 * Класс для обработки пользовательских запросов
 * */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private TrainService customerService;
    /**
     * Метод для вывода инфрмации обо всех расписаниях
     * @return Возвращает список всех расписаний
     * */
    @GetMapping
    public ResponseEntity<?> allSchedules() {
        List<Schedule> schedules = scheduleService.getAll();
        if (schedules.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok().body(schedules);
    }
    /**
     * Метод для сохранения в бд введенной пользователем информации о расписании
     * @return При успешком сохранении возвращает сообщение "Расписание добавлено"
     * */
    @PostMapping("/create")
    public ResponseEntity<?> createSchedule(@RequestBody Schedule schedule) {
        scheduleService.create(schedule);
        return ResponseEntity.ok().body("Расписание добавлено");
    }

}
