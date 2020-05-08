package com.capgemini.go.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capgemini.go.exception.ResourceNotFoundException;
import com.capgemini.go.model.Address;
import com.capgemini.go.repository.AddressRepository;;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class AddressController {
	
	    @Autowired
	    private AddressRepository addressRepository;

	    @GetMapping("/address")
	    public List<Address> getAllAddress() {
	        return addressRepository.findAll();
	    }

	    @GetMapping("/address/{addressId}")
	    public ResponseEntity<Address> getAddressId(@PathVariable(value = "addressId") Long addressId)
	        throws ResourceNotFoundException {
	    	Address address = addressRepository.findById(addressId)
	          .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + addressId));
	        return ResponseEntity.ok().body(address);
	    }
	    
	    @PostMapping("/address")
	    public Address createAddress(@Valid @RequestBody Address address) {
	        return addressRepository.save(address);
	    }

	    @PutMapping("/address/{addressId}")
	    public ResponseEntity<Address> updateAddress(@PathVariable(value = "addressId") Long addressId,
	         @Valid @RequestBody Address addressDetails) throws ResourceNotFoundException {
	    	Address address = addressRepository.findById(addressId)
	        .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + addressId));

	        address.setAddressId(addressDetails.getAddressId());
	        address.setBuildingNo(addressDetails.getBuildingNo());
	        address.setCity(addressDetails.getCity());
	        address.setState(addressDetails.getState());
	        address.setField(addressDetails.getField());
	        address.setZip(addressDetails.getZip());
	        final Address updatedAddress = addressRepository.save(address);
	        return ResponseEntity.ok(updatedAddress);
	    }

	    @DeleteMapping("/address/{addressId}")
	    public Map<String, Boolean> deleteAddress(@PathVariable(value = "addressId") Long addressId)
	         throws ResourceNotFoundException {
	        Address address = addressRepository.findById(addressId)
	       .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + addressId));

	        addressRepository.delete(address);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	   
	}
