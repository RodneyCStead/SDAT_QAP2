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

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/start-date/{startDate}")
    public List<Tournament> searchTournamentsByStartDate(@PathVariable LocalDate startDate) {
        return tournamentService.searchTournamentsByStartDate(startDate);
    }

    @GetMapping("/by-city/{city}")
    public List<Tournament> searchTournamentsByLocation(@PathVariable String city) {
        return tournamentService.searchTournamentsByLocation(city);
    }

    @GetMapping("/members/{tournamentId}")
    public List<String> findAllMembersInTournament(@PathVariable Long tournamentId) {
        return tournamentService.findAllMembersInTournament(tournamentId);
    }
}