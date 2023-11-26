package com.unirent.repository;

import com.unirent.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    // Esempio di query personalizzata per trovare un cliente per email
    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    Customer findByEmail(@Param("email") String email);

    // Esempio di query personalizzata per trovare tutti i clienti con un certo cognome
    List<Customer> findByLastName(String lastName);

    // Altre query personalizzate, se necessario 
}
