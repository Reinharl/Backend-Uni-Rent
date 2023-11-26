package com.unirent.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rent")
@Data
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "apartment_id", nullable = false)
    private Apartment apartment;

    @ManyToOne
    @JoinColumn(name = "lodger_id", nullable = false)
    private Customer lodger;


}

