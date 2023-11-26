package com.unirent.repository;

import com.unirent.entity.Customer_interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface Customer_interestRepository extends JpaRepository<Customer_interest, Long> {
}
