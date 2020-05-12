package com.capgemini.go.service;

import java.util.List;
import java.util.Map;

import com.capgemini.go.exception.AddressNotFoundException;
import com.capgemini.go.model.Address;

public interface AddressService {
	
	 List<Address> getAllAddress();
	 
	 Address getAddressId(Long addressId) throws AddressNotFoundException;
	 
	 Address createAddress(Address address);
	 
	 Address updateAddress(Long addressId, Address addressDetails) throws AddressNotFoundException;
	 
	 Map<String, Boolean> deleteAddress(Long addressId) throws AddressNotFoundException;

}
