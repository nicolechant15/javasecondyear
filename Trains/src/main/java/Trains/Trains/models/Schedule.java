package Trains.Trains.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


/**
 * Класс, представляющий таблицу расписаний поездов
 * */

@Entity
@Getter
@Setter
public class Schedule {
    /**
     * Идентификатор расписания
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    /**
     * Откуда и куда отправление
     * */
    @Column(nullable = false)
    private String from, where;
    /**
     * Цена билета
     * */
    @Column(nullable = false)
    private Float price;
    /**
     * Связь с таблицей поездов
     * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id", nullable = false)

    private Train schedule;


}
