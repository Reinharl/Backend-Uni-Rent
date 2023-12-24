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
            "and (:available is null or apartment.available = :available)"+
            "and (:wifi is null or apartment.wifi = :wifi)" +
            "and (:elevator is null or apartment.elevator = :elevator)" +
            "and (:kitchen is null or apartment.kitchen = :kitchen)" +
            "and (:washingMachine is null or apartment.washingMachine = :washingMachine)" +
            "and (:dishwasher is null or apartment.dishwasher = :dishwasher)" +
            "and (:roomStudy is null or apartment.roomStudy = :roomStudy)" +
            "and (:garden is null or apartment.garden = :garden)" +
            "and (:alarm is null or apartment.alarm = :alarm)" +
            "and (:airConditioning is null or apartment.airConditioning = :airConditioning)" +
            "and (:furniture is null or apartment.furniture = :furniture)" +
            "and (:ensuiteBathroom is null or apartment.ensuiteBathroom = :ensuiteBathroom)" +
            "and (:soundproofWindows is null or apartment.soundproofWindows = :soundproofWindows)" +
            "and (:billsIncluded is null or apartment.billsIncluded = :billsIncluded)" +
            "and (:bikeStorage is null or apartment.bikeStorage = :bikeStorage)"

    )
    Page<Apartment> findApartmentFilters(
            @Param("city") String city,
            @Param("heating") Boolean heating,
            @Param("animals") Boolean animals,
            @Param("available") Boolean available,
            @Param("wifi") Boolean wifi,
            @Param("elevator") Boolean elevator,
            @Param("kitchen") Boolean kitchen ,
            @Param("washingMachine") Boolean washingMachine ,
            @Param("dishwasher") Boolean dishwasher,
            @Param("roomStudy") Boolean room_study,
            @Param("garden") Boolean garden ,
            @Param("alarm") Boolean alarm,
            @Param("airConditioning") Boolean airConditioning,
            @Param("furniture") Boolean furniture,
            @Param("ensuiteBathroom") Boolean ensuiteBathroom,
            @Param("soundproofWindows") Boolean soundproofWindows,
            @Param("billsIncluded") Boolean billsIncluded,
            @Param("bikeStorage") Boolean bikeStorage,
            Pageable pageable);
}