package com.unirent.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rent")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "apartment", nullable = false)
    private Apartment apartment;

    @ManyToOne
    @JoinColumn(name = "lodger", nullable = false)
    private Customer lodger;


}

