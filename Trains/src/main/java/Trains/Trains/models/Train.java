package Trains.Trains.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *Класс, представляющий таблицу поездов
 * */

@Entity
@Getter
@Setter
public class Train {
    /**
     * Идентификатор поезда
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    /**
     * Название и тип поезда
     * */
    @Column(nullable = false)
    private String name, type;
    /**
     * Количество вагонов и мест
     * */
    @Column(nullable = false)
    private Integer cars, seats;
    /**
     * Связь с таблицей расписаний
     * */
    @JsonIgnore
    @OneToMany(mappedBy = "schedule")
    private List<Schedule> train;
}
