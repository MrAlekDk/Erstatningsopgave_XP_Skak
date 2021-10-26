package com.xp_skak.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "sponsors")
public class Sponsor {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "phonenr", nullable = false)
    private int phoneNr;

    @Column(name = "email", nullable = false)
    private String email;
}
