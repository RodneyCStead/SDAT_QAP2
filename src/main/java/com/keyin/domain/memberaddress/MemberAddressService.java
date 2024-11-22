package com.keyin.domain.memberaddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberAddressService {

    @Autowired
    private MemberAddressRepository memberAddressRepository;

    public List<MemberAddress> createMemberAddresses(List<MemberAddress> memberAddresses) {
        for (MemberAddress memberAddress : memberAddresses) {
            MemberAddress addressInDB = findMemberAddressByStreetAndHouseNumber(memberAddress);
            if (addressInDB != null && addressInDB.getCity().equals(memberAddress.getCity())) {
                memberAddress = addressInDB;
            }
            memberAddressRepository.save(memberAddress);
        }
        return memberAddresses;
    }

    public List<MemberAddress> findAllMemberAddresses() {
        return (List<MemberAddress>) memberAddressRepository.findAll();
    }

    private MemberAddress findMemberAddressByStreetAndHouseNumber(MemberAddress memberAddress) {
        return memberAddressRepository.findByStreetAndHouseNumber(memberAddress.getStreet(), memberAddress.getHouseNumber());
    }

    public Optional<MemberAddress> getMemberAddressById(Long id) {
        return memberAddressRepository.findById(id);
    }

    public void deleteMemberAddress(Long id) {
        memberAddressRepository.deleteById(id);
    }
}