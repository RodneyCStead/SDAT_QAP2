package com.keyin.domain.member;

import com.keyin.domain.memberaddress.MemberAddress;
import com.keyin.domain.tournament.Tournament;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate startDate;
    private int membershipDuration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private MemberAddress address;

    @ManyToMany(mappedBy = "members")
    private Set<Tournament> tournaments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return membershipDuration;
    }

    public void setDuration(int duration) {
        this.membershipDuration = duration;
    }

    public MemberAddress getAddress() {
        return address;
    }

}
