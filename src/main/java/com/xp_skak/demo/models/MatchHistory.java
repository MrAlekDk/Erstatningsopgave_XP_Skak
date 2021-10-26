package com.xp_skak.demo.models;

import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Table(name = "match_history")
public class MatchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    //TODO er det korrekt?
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "winner_member_id", referencedColumnName = "id", nullable = false)
    private Member winnerMember;

    //TODO er det korrekt?
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loser_member_id", referencedColumnName = "id", nullable = false)
    private Member loserMember;

    @Column(name = "points", nullable = false)
    private int points = 10;

    @Column(name = "game_type", nullable = false)
    private String gameType;
}
