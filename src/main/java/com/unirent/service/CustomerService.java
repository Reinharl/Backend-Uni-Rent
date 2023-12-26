package com.unirent.service;

import com.unirent.entity.Customer;

import java.util.Optional;

public interface CustomerService {

    String findAllLodgerAndInterests();

    Long findFirstNumberInResponse(String response);

    Optional<Customer> findById(Long id);
}
