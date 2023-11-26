package com.unirent.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat")
@Data
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_1_id", nullable = false)
    private Customer customer1;

    @ManyToOne
    @JoinColumn(name = "customer_2_id", nullable = false)
    private Customer customer2;

    @Column(name = "message")
    private String message;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;
}
