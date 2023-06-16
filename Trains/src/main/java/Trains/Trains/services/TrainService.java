package Trains.Trains.services;

import Trains.Trains.models.Train;
import Trains.Trains.repositories.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Класс, предсавляющий методы для работы с базой данных
 * */
@Service
public class TrainService {
    @Autowired
    private TrainRepo trainRepo;

    /**
     * Сохраняет в базу данных поезд
     * @param train задает поезд, который нужно сохранить
     * */
    public void create(Train train) {
        trainRepo.save(train);
    }
    /**
     * @return Возвращает список всех поездов
     * */
    public List<Train> getAll() {
        return trainRepo.findAll();
    }

}
