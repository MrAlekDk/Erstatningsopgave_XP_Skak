package com.xp_skak.demo.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xp_skak.demo.services.MemberService;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.Date;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    Long team_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phonenr")
    private String phoneNr;

    @Column(name = "email")
    private String email;

    @Column(name = "rank", nullable = false)
    private int rank;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "team_id", referencedColumnName = "id", insertable = false, updatable = false)
    private String team;

    private Long login_id;


    //private int memberAge = (int) Duration.between((Temporal) getBirthday(), LocalDateTime.now()).toDays() / 365;


    @OneToOne
    @PrimaryKeyJoinColumn(referencedColumnName = "payment_id", name="payment_id")
    @JsonProperty("member_payment")
    private Payment payment;

    public Member(){}

    public Member(String name, Date birthday, String phoneNr, String email) {
        this.name = name;
        this.birthday = birthday;
        this.phoneNr = phoneNr;
        this.email = email;
    }



    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Long getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Long login_id) {
        this.login_id = login_id;
    }
}
