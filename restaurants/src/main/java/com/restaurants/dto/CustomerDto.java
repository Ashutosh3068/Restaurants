package com.restaurants.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDto {

    private String customerName;
    private String customerEmail;
    private String phoneNumber;
    private String location;
    private String dateTime;
    private String Message;
}
