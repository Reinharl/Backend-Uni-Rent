package com.unirent.repository;

import com.unirent.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @RestResource(exported = false)
    List<Customer> findByRole(String role);

}
