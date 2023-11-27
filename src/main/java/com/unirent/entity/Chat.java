package com.unirent.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_1")
    private Customer customer1;

    @ManyToOne
    @JoinColumn(name = "customer_2")
    private Customer customer2;

    @Column(name = "message")
    private String message;

    @CurrentTimestamp
    @Column(name = "date_created")
    private LocalDateTime dateCreated;
}
