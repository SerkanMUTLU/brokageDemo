package com.example.brokagedemo.service;

import com.example.brokagedemo.model.dto.userservice.RegisterRequest;
import com.example.brokagedemo.model.entity.Customer;
import com.example.brokagedemo.model.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;

    private final CustomerService customerService;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(RegisterRequest registerRequest) throws Exception {
        boolean hasCustomerAlreadyCreated = customerService.checkIfExistCustomerByMail(registerRequest.getMail());
        boolean hasUserAlreadyCreated = userService.isUserExist(registerRequest.getUsername());

        if (hasUserAlreadyCreated || hasCustomerAlreadyCreated) {
            throw new Exception("Customer already created");
        }

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        user = userService.saveUser(user);

        Customer customer = generateCustomer(registerRequest, user);
        customerService.createNewCustomer(customer);
    }

    private Customer generateCustomer(RegisterRequest request, User user) {
        Customer customer = new Customer();
        customer.setMail(request.getMail());
        customer.setName(request.getCustomerName());
        customer.setSurname(request.getCustomerSurname());
        customer.setUser(user);

        return customer;
    }

}
