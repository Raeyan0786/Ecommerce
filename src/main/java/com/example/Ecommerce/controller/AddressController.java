package com.example.Ecommerce.controller;

import com.example.Ecommerce.model.Address;
import com.example.Ecommerce.service.AddressService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
    @PostMapping("/address")
    public String addAddress(@RequestBody String address)
    {
        JSONObject json=new JSONObject(address);
        Address address1=addressService.setAddress(json);
        addressService.saveAddress(address1);
        return "Address is saved";
    }
}
