package com.keyin.domain.tournamentLocation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentLocationRepository extends CrudRepository<TournamentLocation, Long> {
}

