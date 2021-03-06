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
    @Autowired
    TournamentRepository tournamentRepository;


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

    public void deleteMatch(Long playerId) {

        /*
        matchRepository.deleteMatchesByWinnerId(playerId);


        while (matchRepository.deleteMatchesByWinnerId(playerId, playerId) != null) {
            Match winnerIdMatch = matchRepository.deleteMatchesByWinnerId(playerId, playerId);
            matchRepository.delete(winnerIdMatch);
        }

        while (matchRepository.findByloser_member_id(playerId) != null) {
            Match loserIdMatch = matchRepository.findByloser_member_id(playerId);
            matchRepository.delete(loserIdMatch);
        }


        Match winnerIdMatch = matchRepository.findBywinner_member_id(playerId);
        matchRepository.delete(winnerIdMatch);

        Match loserIdMatch = matchRepository.findByloser_member_id(playerId);
        matchRepository.delete(loserIdMatch);
        */

    }

    public List<Tournament> getAllTournaments() {
        List<Tournament> allTournaments = new ArrayList<>();
        tournamentRepository.findAll().forEach(allTournaments::add);
        return allTournaments;
    }

    public void saveNewTournament(Tournament newTournament) {
        tournamentRepository.save(newTournament);
    }

    public Tournament getSpecificTournament(Long id) {
        return tournamentRepository.findById(id).get();
    }

    public void updateTournament(Tournament tournamentUpdatet) {
        Tournament tournamentToUpdate = tournamentRepository.findById(tournamentUpdatet.getId()).get();

        tournamentToUpdate = tournamentUpdatet;
        tournamentRepository.save(tournamentToUpdate);
    }

    public void deleteTournamentById(Long tournamentId) {
        tournamentRepository.deleteById(tournamentId);
    }
}
