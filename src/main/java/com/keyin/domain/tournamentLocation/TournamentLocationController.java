package com.keyin.domain.tournamentLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournament-locations")
public class TournamentLocationController {

    @Autowired
    private TournamentLocationService tournamentLocationService;

    @PostMapping
    public List<TournamentLocation> createTournamentLocations(@RequestBody List<TournamentLocation> locations) {
        return tournamentLocationService.createTournamentLocations(locations);
    }
}