package com.keyin.domain.tournament;

import com.keyin.domain.member.MemberService;
import com.keyin.domain.tournamentLocation.TournamentLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TournamentLocationService tournamentLocationService;

    @Autowired
    private MemberService memberService;

    public List<Tournament> createTournaments(List<Tournament> tournaments) {
        for (Tournament tournament : tournaments) {
            tournament.setLocation(tournamentLocationService.findById(tournament.getLocation().getId()));
        }
        return (List<Tournament>) tournamentRepository.saveAll(tournaments);
    }

    public List<Tournament> searchTournamentsByStartDate(LocalDate startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    public List<Tournament> searchTournamentsByLocation(String city) {
        return tournamentRepository.findByLocation_City(city);
    }
}
