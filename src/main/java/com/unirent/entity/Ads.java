package com.unirent.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ads")
@Data
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;
}
