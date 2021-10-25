package com.xp_skak.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    //TODO Vi skal lige overveje om vores foreign key skal være i teamleaeder eller team tabellen.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teamleader_id", referencedColumnName = "id")
    private Teamleader teamleader;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teamleader getTeamleader() {
        return teamleader;
    }

    public void setTeamleader(Teamleader teamleader) {
        this.teamleader = teamleader;
    }
}
