package com.capgemini.go.controller;

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

import com.capgemini.go.exception.AddressNotFoundException;
import com.capgemini.go.model.Address;
import com.capgemini.go.service.AddressService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class AddressController {
	
	    @Autowired
	    private AddressService addressService;

	    @GetMapping("/address")
	    public List<Address> getAllAddress() {
	        return addressService.getAllAddress();
	    }

	    @GetMapping("/address/{addressId}")
	    public ResponseEntity<Address> getAddressId(@PathVariable(value = "addressId") Long addressId)
	        throws AddressNotFoundException {
	    	Address address = addressService.getAddressId(addressId);
	        return ResponseEntity.ok().body(address);
	    }
	    
	    @PostMapping("/address")
	    public Address createAddress(@Valid @RequestBody Address address) {
	        return addressService.createAddress(address);
	    }

	    @PutMapping("/address/{addressId}")
	    public ResponseEntity<Address> updateAddress(@PathVariable(value = "addressId") Long addressId,
	         @Valid @RequestBody Address addressDetails) throws AddressNotFoundException {
	    	Address address = addressService.updateAddress(addressId, addressDetails);
	        return ResponseEntity.ok(address);
	    }

	    @DeleteMapping("/address/{addressId}")
	    public Map<String, Boolean> deleteAddress(@PathVariable(value = "addressId") Long addressId)
	         throws AddressNotFoundException {
	        
	        return addressService.deleteAddress(addressId);
	    }
	   
	}
