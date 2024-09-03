package com.restaurants.controller;

import com.restaurants.dto.CustomerDto;
import com.restaurants.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerDto> SaveCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto savedto = customerService.saveCustomer(customerDto);
        return new ResponseEntity<>(savedto, HttpStatus.CREATED);

        //http://localhost:8080/api/customer/create
    }

    @GetMapping("/read/{customerid}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String customerid){
        CustomerDto readDto = customerService.getCustomerById(customerid);
        return new ResponseEntity<>(readDto, HttpStatus.OK);

        //http://localhost:8080/api/customer/read/{Customerid}
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/update/{Customerid}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable String Customerid){
        CustomerDto updatedDto = customerService.updateCustomer(Customerid);
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);

        //http://localhost:8080/api/customer/update/{Customerid}
    }

    @DeleteMapping("/delete/{Customerid}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable String Customerid){
        CustomerDto deleteDto = customerService.deleteCustomer(Customerid);
        return new ResponseEntity<>(deleteDto, HttpStatus.NO_CONTENT);

        //http://localhost:8080/api/customer/delete/{Customerid}
    }
}
