package com.keyin.domain.tournamentLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentLocationService {

    @Autowired
    private TournamentLocationRepository tournamentLocationRepository;


    public List<TournamentLocation> createTournamentLocations(List<TournamentLocation> locations) {
        return (List<TournamentLocation>) tournamentLocationRepository.saveAll(locations);
    }

    public TournamentLocation findById(Long id) {
        return tournamentLocationRepository.findById(id).orElse(null);
    }
}