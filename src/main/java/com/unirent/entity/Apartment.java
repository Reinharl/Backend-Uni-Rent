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

    @ManyToOne
    @JoinColumn(name = "owner")
    private Customer owner;

}
