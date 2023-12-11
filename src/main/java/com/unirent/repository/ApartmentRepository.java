package com.unirent.repository;

import com.unirent.entity.Apartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    @RestResource(exported = false)
    @Query("SELECT DISTINCT apartment.city FROM Apartment apartment")
    List<String> findDistinctCities();

    @Query("SELECT apartment " +
            "FROM Apartment apartment " +
            "WHERE ((:city is null or trim(:city) = '') or apartment.city = :city) " +
            "and (:heating is null or apartment.heating = :heating)" +
            "and (:animals is null or apartment.animals = :animals)" +
            "and (:available is null or apartment.available = :available)"
    )
    Page<Apartment> findApartmentFilters(
            @Param("city") String city,
            @Param("heating") Boolean heating,
            @Param("animals") Boolean animals,
            @Param("available") Boolean available,
            Pageable pageable);
}
