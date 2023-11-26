package com.unirent.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "apartment")
@Data
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
    
    @Column(name = "image_url")
    private String imageUrl;

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

    @Column(name = "monthly_rent")
    private BigDecimal monthlyRent;

    @Column(name = "montly_price")
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
    private String heating;

    @Column(name = "available")
    private boolean available;

    @Column(name = "owner")
    private String owner;

    // Add other necessary fields related to Apartment entity, if needed

    // Constructors, getters, setters, and other methods can be added as needed
}
