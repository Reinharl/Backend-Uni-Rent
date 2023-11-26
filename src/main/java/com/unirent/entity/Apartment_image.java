package com.unirent.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "apartment_image")
@Data
public class Apartment_image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "apartment_id", nullable = false)
    private Apartment apartment;

    @Column(name = "image_url")
    private String imageUrl;


}
