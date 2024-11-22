package com.keyin.domain.tournament;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {
    List<Tournament> findByStartDate(LocalDate startDate);
    @Query("SELECT t FROM Tournament t JOIN t.location l WHERE l.city = :city")
    List<Tournament> findByLocationCity(String city);

}
