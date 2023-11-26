package com.unirent.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer_interest")
@Data
public class Customer_interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer lodger;

    @ManyToOne
    @JoinColumn(name = "interest_id", nullable = false)
    private Interest interest;

    // Constructors, getters, setters, and other methods can be added as needed
}
