package com.example.Ecommerce.dao;

import com.example.Ecommerce.model.Address;
import com.example.Ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
