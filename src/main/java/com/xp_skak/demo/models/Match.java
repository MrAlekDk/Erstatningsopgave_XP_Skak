package com.xp_skak.demo.models;

import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Table(name = "match_history")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    //TODO er det korrekt?
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "winner_member_id", referencedColumnName = "id", nullable = false)
    private Member winnerMember;

    //TODO er det korrekt?
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "loser_member_id", referencedColumnName = "id", nullable = false)
    private Member loserMember;

    @Column(name = "game_type", nullable = false)
    private String gameType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getWinnerMember() {
        return winnerMember;
    }

    public void setWinnerMember(Member winnerMember) {
        this.winnerMember = winnerMember;
    }

    public Member getLoserMember() {
        return loserMember;
    }

    public void setLoserMember(Member loserMember) {
        this.loserMember = loserMember;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
}
