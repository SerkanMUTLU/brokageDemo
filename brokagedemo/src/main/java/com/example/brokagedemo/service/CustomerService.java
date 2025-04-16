package com.example.brokagedemo.service;

import com.example.brokagedemo.model.dto.customerservice.CustomerResponse;
import com.example.brokagedemo.model.mappers.CustomerMapper;
import com.example.brokagedemo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    public CustomerResponse getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toCustomerResponse)
                .orElse(null);
    }

    public Boolean checkCustomerExistById(Long id) {
        return customerRepository.existsById(id);
    }

}
