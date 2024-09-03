package com.restaurants.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerEntity {

    @Id
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String phoneNumber;
    private String location;
    private String dateTime;

}
