package com.capgemini.go.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.dao.AddressDao;
import com.capgemini.go.exception.AddressNotFoundException;
import com.capgemini.go.model.Address;

@Service
public class AddressServiceImpl implements AddressService{
	
	 @Autowired
	 private AddressDao addressRepository;
	 
	 
	 public List<Address> getAllAddress() {
		 return addressRepository.findAll();
		 }
	 
	 public Address getAddressId(Long addressId) throws AddressNotFoundException{
		 Address address = addressRepository.findById(addressId).orElseThrow(() -> new AddressNotFoundException("Address not found for this id :: " + addressId));
		        return address;
		    }
	 
	 public Address createAddress(Address address){
		 return addressRepository.save(address);
		 }
	 
	 public Address updateAddress(Long addressId, Address addressDetails) throws AddressNotFoundException {
		 Address address = addressRepository.findById(addressId).orElseThrow(() -> new AddressNotFoundException("Address not found for this id :: " + addressId));
		 address.setAddressId(addressDetails.getAddressId());
		 address.setBuildingNo(addressDetails.getBuildingNo());
		 address.setCity(addressDetails.getCity());
		 address.setState(addressDetails.getState());
		 address.setField(addressDetails.getField());
		 address.setZip(addressDetails.getZip());
		 final Address updatedAddress = addressRepository.save(address);
		 return updatedAddress;
	    }
	 
	 public Map<String, Boolean> deleteAddress(Long addressId) throws AddressNotFoundException {
	        Address address = addressRepository.findById(addressId).orElseThrow(() -> new AddressNotFoundException("Address not found for this id :: " + addressId));
	        addressRepository.delete(address);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}
