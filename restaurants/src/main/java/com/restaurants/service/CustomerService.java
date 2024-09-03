package com.restaurants.service;


import com.restaurants.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto saveCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(String customerid);

    CustomerDto updateCustomer(String customerid);

    CustomerDto deleteCustomer(String customerid);

    List<CustomerDto> getAllCustomers();
}
