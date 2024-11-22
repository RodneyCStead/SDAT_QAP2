package com.keyin.domain.member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    List<Member> findByName(String name);
    List<Member> findByPhoneNumber(String phoneNumber);
    List<Member> findByStartDate(LocalDate startDate);
    List<Member> findByMembershipDuration(int duration);


}