package Trains.Trains.repositories;

import Trains.Trains.models.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepo extends JpaRepository<Train, Long> {
}
