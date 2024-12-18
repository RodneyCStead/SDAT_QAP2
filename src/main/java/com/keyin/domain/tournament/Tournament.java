package com.keyin.domain.tournament;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    private com.keyin.domain.tournamentLocation.TournamentLocation location;


    @ElementCollection
    private List<Long> registeredMembers;


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

    public void setLocation(com.keyin.domain.tournamentLocation.TournamentLocation location) {
        this.location = location;
    }

    public List<Long> getRegisteredMembers() {
        return registeredMembers;
    }

    public void setRegisteredMembers(List<Long> registeredMembers) {
        this.registeredMembers = registeredMembers;
    }
}