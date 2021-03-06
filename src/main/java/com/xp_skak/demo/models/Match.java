package com.xp_skak.demo.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "match_history")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "winner_member_id", referencedColumnName = "id", nullable = false)
    private String winnerMemberName;

//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "loser_member_id", referencedColumnName = "id", nullable = false)
    private String loserMemberName;

    @Column(name = "game_type", nullable = false)
    private String gameType;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date matchDate;

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWinnerMemberName() {
        return winnerMemberName;
    }

    public void setWinnerMemberName(String winnerMember) {
        this.winnerMemberName = winnerMember;
    }

    public String getLoserMemberName() {
        return loserMemberName;
    }

    public void setLoserMemberName(String loserMember) {
        this.loserMemberName = loserMember;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
}
