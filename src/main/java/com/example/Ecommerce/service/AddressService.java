package com.example.Ecommerce.service;

import com.example.Ecommerce.dao.AddressRepository;
import com.example.Ecommerce.dao.UserRepository;
import com.example.Ecommerce.model.Address;
import com.example.Ecommerce.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

    public void saveAddress(Address address){
        addressRepository.save(address);
    }
    public Address setAddress(JSONObject jsonObject)
    {
        Address address=new Address();
        address.setAddressId(jsonObject.getInt("addressId"));
        address.setLandmark(jsonObject.getString("landmark"));
        address.setState(jsonObject.getString("state"));
        address.setZipcode(jsonObject.getString("zipcode"));
        address.setCityName(jsonObject.getString("cityName"));
        address.setPhoneNo(jsonObject.getString("phoneNo"));
        int id= jsonObject.getInt("user");
        User user=userRepository.findById(id).get();
        address.setUser(user);
        return address;
    }
}
