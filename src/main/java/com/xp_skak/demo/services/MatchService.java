package com.xp_skak.demo.services;

import com.xp_skak.demo.models.Match;
import com.xp_skak.demo.models.Tournament;
import com.xp_skak.demo.repositories.MatchRepository;
import com.xp_skak.demo.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    //TODO Construction injection skal fixes
    @Autowired
    MatchRepository matchRepository;
    TournamentRepository tournamentRepository;

    public MatchService(MatchRepository matchRepository, TournamentRepository tournamentRepository){
        this.matchRepository=matchRepository;
        this.tournamentRepository=tournamentRepository;
    }

    public MatchService() {
    }

    public List<Match> getAllMatches() {
        List<Match> allMatches = new ArrayList<>();
        matchRepository.findAll().forEach(allMatches::add);
        return allMatches;
    }

    public void saveMatch(Match match) {
        matchRepository.save(match);
    }


    public List<Tournament> getAllTournaments() {
        List<Tournament> allTournaments = new ArrayList<>();
        tournamentRepository.findAll().forEach(allTournaments::add);
        return allTournaments;
    }

    public void saveNewTournament(Tournament Newtournament) {
        tournamentRepository.save(Newtournament);
    }
}
