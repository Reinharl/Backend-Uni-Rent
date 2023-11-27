package com.unirent.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "lodger_interest")
public class LodgerInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lodger")
    private Customer lodger;

    @ManyToOne
    @JoinColumn(name = "interest")
    private Interest interest;

}
