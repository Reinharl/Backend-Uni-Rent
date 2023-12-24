package com.unirent.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "apartment")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "civic_number")
    private String civicNumber;

    @Column(name = "cap_number")
    private String capNumber;

    @Column(name = "bathrooms")
    private int bathrooms;

    @Column(name = "monthly_price")
    private BigDecimal monthlyPrice;

    @Column(name = "rooms")
    private int rooms;

    @Column(name = "size")
    private int size;

    @Column(name = "floor")
    private int floor;

    @Column(name = "animals")
    private boolean animals;

    @Column(name = "deposit")
    private BigDecimal deposit;

    @Column(name = "heating")
    private boolean heating;

    @Column(name = "available")
    private boolean available;

    @Column(name = "wifi")
    private boolean wifi;

    @Column(name = "elevator")
    private boolean elevator;

    @Column(name = "kitchen")
    private boolean kitchen;

    @Column(name = "washing_machine")
    private boolean washingMachine ;

    @Column(name = "dishwasher")
    private boolean dishwasher;

    @Column(name = "room_study")
    private boolean roomStudy;

    @Column(name = "garden")
    private boolean garden;

    @Column(name = "alarm")
    private boolean alarm;

    @Column(name = "air_conditioning")
    private boolean airConditioning;

    @Column(name = "furniture")
    private boolean furniture ;

    @Column(name = "ensuite_bathroom")
    private boolean ensuiteBathroom;

    @Column(name = "soundproof_windows")
    private boolean soundproofWindows;

    @Column(name = "bills_included")
    private boolean billsIncluded;

    @Column(name = "bike_storage")
    private boolean bikeStorage;

    @ManyToOne
    @JoinColumn(name = "owner")
    private Customer owner;

}