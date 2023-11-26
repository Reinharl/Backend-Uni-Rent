package com.unirent.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "interest")
@Data
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "music")
    private String music;

    @Column(name = "film")
    private String film;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "sport")
    private String sport;

    @Column(name = "animals")
    private String animals;

}
