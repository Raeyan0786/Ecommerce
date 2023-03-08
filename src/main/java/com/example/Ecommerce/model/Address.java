package com.example.Ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="address")
public class Address {
    @Id
    private  Integer addressId;
    private String cityName;
    private String landmark;
    private String  phoneNo;
    private String  zipcode;
    private String state;
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
