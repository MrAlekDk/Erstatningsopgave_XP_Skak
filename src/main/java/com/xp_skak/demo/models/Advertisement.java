package com.xp_skak.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "advertisements")
public class Advertisement {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;

    //TODO Tjek ManyToONe om den er rigtig
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    private Company company;
}
