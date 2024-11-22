package com.keyin.domain.memberaddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/member-addresses")
public class MemberAddressController {

    @Autowired
    private MemberAddressService memberAddressService;

    @PostMapping
    public List<MemberAddress> createMemberAddresses(@RequestBody List<MemberAddress> memberAddresses) {
        return memberAddressService.createMemberAddresses(memberAddresses);
    }

    @GetMapping("/{id}")
    public Optional<MemberAddress> getMemberAddressById(@PathVariable Long id) {
        return memberAddressService.getMemberAddressById(id);
    }

    @GetMapping
    public List<MemberAddress> getAllMemberAddresses() {
        return memberAddressService.findAllMemberAddresses();
    }

    @DeleteMapping("/{id}")
    public void deleteMemberAddress(@PathVariable Long id) {
        memberAddressService.deleteMemberAddress(id);
    }
}