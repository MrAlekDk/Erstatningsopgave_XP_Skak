package com.xp_skak.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "date", nullable = false)
    private Date date;

    //TODO Vi skal lige overveje om vores foreign key skal være i participants eller tournament tabellen og,
    // ManyToOne eller OneToMany.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "winner", referencedColumnName = "participants")
    private Participant participant;

    public Tournament(){
    }

    public Tournament(String name, int price, Date date){
        this.name=name;
        this.price=price;
        this.date=date;
    }

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

    public int getPrize() {
        return price;
    }

    public void setPrize(int prize) {
        this.price = prize;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
