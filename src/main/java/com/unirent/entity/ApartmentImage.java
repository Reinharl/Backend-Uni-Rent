package com.unirent.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "apartment_image")
public class ApartmentImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "apartment")
    private Apartment apartment;

    @Column(name = "image")
    private String image;

}
