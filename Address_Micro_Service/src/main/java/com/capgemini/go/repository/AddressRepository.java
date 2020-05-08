package com.capgemini.go.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.go.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
