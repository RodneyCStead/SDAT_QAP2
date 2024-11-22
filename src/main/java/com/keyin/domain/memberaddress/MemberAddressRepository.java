package com.keyin.domain.memberaddress;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberAddressRepository extends CrudRepository<MemberAddress, Long> {
    @Query("SELECT ma FROM MemberAddress ma WHERE ma.street = ?1 AND ma.houseNumber = ?2")
    MemberAddress findByStreetAndHouseNumber(String street, String houseNumber);}
