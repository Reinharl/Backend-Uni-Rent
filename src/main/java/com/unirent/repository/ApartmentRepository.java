package com.unirent.repository;

import com.unirent.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    @Query("SELECT DISTINCT apartment.city FROM Apartment apartment")
    List<String> findDistinctCities();
}
