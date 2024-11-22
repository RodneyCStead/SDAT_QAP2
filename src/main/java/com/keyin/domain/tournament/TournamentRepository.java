package com.keyin.domain.tournament;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {

}
