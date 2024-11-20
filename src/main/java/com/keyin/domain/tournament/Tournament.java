package com.keyin.domain.tournament;

import com.keyin.domain.member.Member;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private double entryFee;
    private double cashPrize;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private com.keyin.domain.tournamentLocation.TournamentLocation  location;

    @ManyToMany
    @JoinTable(
            name = "tournament_member",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private Set<Member> members;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public double getCashPrize() {
        return cashPrize;
    }

    public void setCashPrize(double cashPrize) {
        this.cashPrize = cashPrize;
    }

    public com.keyin.domain.tournamentLocation.TournamentLocation getLocation() {
        return location;
    }
}
