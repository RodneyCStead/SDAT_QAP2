package com.keyin.domain.member;

import com.keyin.domain.memberaddress.MemberAddress;
import com.keyin.domain.memberaddress.MemberAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberAddressRepository memberAddressRepository;

    public List<Member> saveAll(List<Member> members) {
        for (Member member : members) {
            Optional<MemberAddress> address = memberAddressRepository.findById(member.getAddress().getId());
            address.ifPresent(member::setAddress);
        }
        return (List<Member>) memberRepository.saveAll(members);
    }

    public List<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }

    public List<Member> findByPhoneNumber(String phoneNumber) {
        return memberRepository.findByPhoneNumber(phoneNumber);
    }

    public List<Member> findByStartDate(LocalDate startDate) {
        return memberRepository.findByStartDate(startDate);
    }

    public List<Member> findAllMembers() {
        return (List<Member>) memberRepository.findAll();
    }

    public List<Member> findByMembershipDuration(int duration) {
        return memberRepository.findByMembershipDuration(duration);
    }


}