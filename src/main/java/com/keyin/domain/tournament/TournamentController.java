package com.keyin.domain.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @PostMapping
    public List<Tournament> createTournaments(@RequestBody List<Tournament> tournaments) {
        return tournamentService.createTournaments(tournaments);
    }
    @GetMapping("/search/StartDate")
    public List<Tournament> searchTournamentsByStartDate(@RequestParam LocalDate startDate) {
        return tournamentService.searchTournamentsByStartDate(startDate);
    }

    @GetMapping("/search/Location")
    public List<Tournament> searchTournamentsByLocation(@RequestParam String city) {
        return tournamentService.searchTournamentsByLocation(city);
    }
}