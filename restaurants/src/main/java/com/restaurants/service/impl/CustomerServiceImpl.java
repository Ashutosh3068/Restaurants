package com.restaurants.service.impl;

import com.restaurants.dto.CustomerDto;
import com.restaurants.exception.CustomerNotFoundException;
import com.restaurants.model.CustomerEntity;
import com.restaurants.repository.CustomerRepo;
import com.restaurants.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
  @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        String id = UUID.randomUUID().toString();
        CustomerEntity entity = dtoToEntity(customerDto);
        entity.setCustomerId(id);
        CustomerEntity save = customerRepo.save(entity);
        CustomerDto customerDto1 = entityToDto(save);
        return customerDto1;
    }

    @Override
    public CustomerDto getCustomerById(String customerid) {
        Optional<CustomerEntity> entity = customerRepo.findById(customerid);

        if (entity.isPresent()) {

            return entityToDto(entity.get());
        }
        return null;
    }

    @Override
    public CustomerDto updateCustomer(String customerid) {
        CustomerEntity update = customerRepo.findById(customerid).get();
        CustomerDto customerDto = entityToDto(update);
        return customerDto;
    }

    @Override
    public CustomerDto deleteCustomer(String customerId) {
        CustomerEntity entity = customerRepo.findById(customerId).orElseThrow(
                () -> new CustomerNotFoundException("Customer with ID: " + customerId + " not found")
        );
        customerRepo.deleteById(entity.getCustomerId());
        return entityToDto(entity);

    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<CustomerEntity> entities = customerRepo.findAll();
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public CustomerDto entityToDto(CustomerEntity entity) {
        return modelMapper.map(entity, CustomerDto.class);
    }

    public CustomerEntity dtoToEntity(CustomerDto dto) {
        return modelMapper.map(dto, CustomerEntity.class);
    }
}
