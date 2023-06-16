package Trains.Trains.repositories;

import Trains.Trains.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Long>, JpaSpecificationExecutor<Schedule> {
//    @Query(value="SELECT v.id, v.customer, v.service FROM Visit v JOIN v.customer as c WHERE c.id =?1 ", nativeQuery = true)
//    public List<Visit> getVisitByCustomerId(Long id);


//    @Override
//    List<Visit> findBy;
}
