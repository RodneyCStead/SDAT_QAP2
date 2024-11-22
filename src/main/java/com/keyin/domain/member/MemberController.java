package com.keyin.domain.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public List<Member> createMembers(@RequestBody List<Member> members) {
        return memberService.saveAll(members);
    }

    @GetMapping("/name/{name}")
    public List<Member> getMembersByName(@PathVariable String name) {
        return memberService.findByName(name);
    }

    @GetMapping("/phone/{phoneNumber}")
    public List<Member> getMembersByPhoneNumber(@PathVariable String phoneNumber) {
        return memberService.findByPhoneNumber(phoneNumber);
    }

    @GetMapping("/start-date/{startDate}")
    public List<Member> getMembersByStartDate(@PathVariable LocalDate startDate) {
        return memberService.findByStartDate(startDate);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.findAllMembers();
    }


}