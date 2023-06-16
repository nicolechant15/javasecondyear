package Trains.Trains.services;

import Trains.Trains.models.Schedule;
import Trains.Trains.repositories.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Класс, предсавляющий методы для работы с базой данных
 * */
@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepo scheduleRepo;

    /**
     * @return Возвращает список всех расписаний
     * */
    public List<Schedule> getAll() {
        return scheduleRepo.findAll();
    }

    /**
     * Сохраняет в базу данных раписание
     * @param schedule задает расписание, которое нужно сохранить
     * */
    public void create(Schedule schedule) {
        scheduleRepo.save(schedule);
    }
}
