package com.keyin.domain.tournament;

import com.keyin.domain.member.Member;
import com.keyin.domain.member.MemberRepository;
import com.keyin.domain.member.MemberService;
import com.keyin.domain.tournamentLocation.TournamentLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
    private MemberRepository memberRepository;

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
        return tournamentRepository.findByLocationCity(city);
    }

    public List<Tournament> getAllTournaments() {
        return (List<Tournament>) tournamentRepository.findAll();
    }

    public List<String> findAllMembersInTournament(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(() -> new RuntimeException("Tournament not found"));
        List<Long> memberIds = tournament.getRegisteredMembers();
        List<String> memberNames = new ArrayList<>();
        for (Long memberId : memberIds) {
            Member member = memberService.findById(memberId);
            memberNames.add(member.getName());
        }
        return memberNames;
    }

    public Tournament addMemberToTournament(Long tournamentId, Long memberId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElse(null);
        if (tournament != null) {
            Member member = memberRepository.findById(memberId).orElse(null);
            if (member != null) {
                tournament.getRegisteredMembers().add(memberId);
                return tournamentRepository.save(tournament);
            }
        }
        return null;
    }
}
