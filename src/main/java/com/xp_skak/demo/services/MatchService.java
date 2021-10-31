package com.xp_skak.demo.services;

import com.xp_skak.demo.models.Match;
import com.xp_skak.demo.repositories.MatchRepository;

import java.util.ArrayList;
import java.util.List;

public class MatchService {

    MatchRepository matchRepository;

    public List<Match> getAllMatches() {
        List<Match> allMatches = new ArrayList<>();
        matchRepository.findAll().forEach(allMatches::add);
        return allMatches;
    }

    public void saveMatch(Match match) {
        matchRepository.save(match);
    }


}
